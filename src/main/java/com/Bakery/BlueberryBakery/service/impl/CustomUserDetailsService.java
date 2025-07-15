package com.Bakery.BlueberryBakery.service.impl;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.Bakery.BlueberryBakery.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with this username");
        }

        List<GrantedAuthority> authority = new ArrayList<>();

        if (user.getRole() != null) {
            for (String r : user.getRole().split(",")) {
                String role = r.trim().startsWith("ROLE_")
                        ? r.trim()
                        : "ROLE_" + r.trim();
                authority.add(new SimpleGrantedAuthority(role));
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authority);

    }
}