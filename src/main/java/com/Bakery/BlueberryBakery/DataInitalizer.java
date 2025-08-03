package com.Bakery.BlueberryBakery;

import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitalizer implements CommandLineRunner {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataInitalizer(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (!repo.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            repo.save(admin);
            System.out.println("Admin was created");
        }
    }
}