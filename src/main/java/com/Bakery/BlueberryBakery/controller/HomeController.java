package com.Bakery.BlueberryBakery.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/menu")
    public String showMenuPage() {
        return "menu";
    }
    @GetMapping("/about-us")
    public String aboutus() {
        return "about-us";
    }
}