package com.Bakery.BlueberryBakery.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AdminController {
    @GetMapping("/admin/login")
    public String adminLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "invalid admin credentials");
            System.out.println(error);
        }
        return "admin-login";
    }
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin-dashboard";
    }
}
