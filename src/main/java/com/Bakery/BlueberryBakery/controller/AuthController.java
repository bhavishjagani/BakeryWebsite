package com.Bakery.BlueberryBakery.controller;

import com.Bakery.BlueberryBakery.model.User;
import com.Bakery.BlueberryBakery.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Currently:
    @GetMapping("/signup")
    public String signupForm(Model model) {
        System.out.println(">>> GET /signup hit");
        model.addAttribute("user", new User());

        return "signup"; // expects signup.html
    }

    @PostMapping("/signup")
    public String processSignup(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("if block");
            model.addAttribute("errorMessage", "Please correct the error.");
            return "signup";
        }
        try {
            userService.register(user);
        }
        catch (IllegalArgumentException e)   {
            System.out.println("catch 1");
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println(e.getMessage());
            return "signup";
        }
        catch (Exception e) {
            System.out.println("catch 2");
            model.addAttribute("errorMessage", "Registration failed " + e.getMessage());
            return "signup";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}