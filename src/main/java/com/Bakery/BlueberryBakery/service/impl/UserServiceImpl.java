package com.Bakery.BlueberryBakery.service.impl;

import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void register(User user) {
        if (user.getReenterpassword() == null || !user.getPassword().equals(user.getReenterpassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        if (repo.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }
        try {
            repo.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new IllegalArgumentException("Unable to register user: " + ex.getMostSpecificCause().getMessage());
        }
    }
}