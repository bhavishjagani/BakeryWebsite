package com.Bakery.BlueberryBakery.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static List<String> cart = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/getProducts")
    public String showMenuPage() {
        return "/getProducts";
    }

    @GetMapping("/about-us")
    public String aboutus() {
        return "about-us";
    }

}