package com.project.RestaurantManagementSystem.controller;

import com.project.RestaurantManagementSystem.entity.Customer;
import com.project.RestaurantManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/register")
    public String registrationForm() {
        return "register";
    }
    @PostMapping("/login")
    public String registration(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobileNumber=request.getParameter("mobileNumber");
        Customer customer = new Customer(userName, name, email, password,mobileNumber);
        customerService.createCustomer(customer);
        return "login";
    }
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/restaurant")
    public String login(HttpServletRequest request, Model model) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Customer customer;
        if (customerService.existsById(userName)) {
            customer = customerService.findCustomerByUserName(userName);
            if (password.equals(customer.getPassword())) {
                model.addAttribute("userName", userName);

            } else {
                model.addAttribute("message", "Wrong Password");
                return "redirect:/login";
            }
        } else {
            model.addAttribute("message", "Please enter valid User Name");
            return "redirect:/login";

        }
        return "restaurant";
    }
}

