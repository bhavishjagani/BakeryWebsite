package com.Bakery.BlueberryBakery;
import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BlueberryBakeryApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlueberryBakeryApplication.class, args);
	}
}