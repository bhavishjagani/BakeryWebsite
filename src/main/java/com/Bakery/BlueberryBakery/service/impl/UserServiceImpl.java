package com.Bakery.BlueberryBakery.service.impl;
import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void register(User user) {
        // 1. Check password confirmation
        if (user.getReenterpassword() == null || !user.getPassword().equals(user.getReenterpassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        // 2. Check username uniqueness
        if (repo.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        // 3. Encode password
        user.setPassword(encoder.encode(user.getPassword()));
        // 4. Optionally set default role if you have roles:
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }
        try {
            repo.save(user);
        } catch (DataIntegrityViolationException ex) {
            // In case unique constraint triggers at DB level
            throw new IllegalArgumentException("Unable to register user: " + ex.getMessage());
        }
    }

}
