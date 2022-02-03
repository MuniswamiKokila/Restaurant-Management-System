package com.project.RestaurantManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @GetMapping("/adminLogin")
    public String admin() {
        return "adminLogin";
    }
    @PostMapping("/adminRestaurant")
    public String adminLogin(HttpServletRequest request, Model model) {
        String adminUserName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        if (adminUserName.equals("admin@123") && adminPassword.equals("admin")) {
            return "redirect:/adminRestaurant";
        }
        else{
            model.addAttribute("message","Invalid Credentials");
            return "redirect:/adminLogin";
        }

    }
}
