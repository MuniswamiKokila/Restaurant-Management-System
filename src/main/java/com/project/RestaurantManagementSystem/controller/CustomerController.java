package com.project.RestaurantManagementSystem.controller;

import com.project.RestaurantManagementSystem.entity.Customer;
import com.project.RestaurantManagementSystem.entity.DineIn;
import com.project.RestaurantManagementSystem.service.CustomerService;
import com.project.RestaurantManagementSystem.service.DineInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Date;
import java.sql.Time;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String index(){
        return "home";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String register(HttpServletRequest req, Model model) {
        String userName = req.getParameter("userName");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Long mobileNumber = Long.parseLong(req.getParameter("mobileNumber"));
        Customer customer;
        if(userName.equals("admin")){
            customer = new Customer(userName, name, email,password, mobileNumber,address,"ROLE_ADMIN");
        }
        else{
            customer = new Customer(userName, name, email,password, mobileNumber,address,"ROLE_USER");

        }
        if(!customerService.existsById(userName)){
            customerService.save(customer);
        }
        else
        {
            model.addAttribute("error","This username is already taken... Please choose another one !!!");
            return "register";
        }
        model.addAttribute("message", "Successfully registered!!!!!!");
        return "login";

    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/success")
    public String login(Principal principal){
        String userName=principal.getName();
        if (userName.equals("admin")){
            return "redirect:/adminRestaurant";
        }
        return "redirect:/restaurant";
    }
    @RequestMapping("/restaurant")
    public String restaurant(){
        return "restaurant";
    }

    @RequestMapping("/viewProfile")
    public String viewProfile(Model model,Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        Customer customer = customerService.findById(principal.getName());

        model.addAttribute("name", customer.getName());
        model.addAttribute("userName", customer.getUserName());
        model.addAttribute("address", customer.getAddress());
        model.addAttribute("email", customer.getEmail());
        model.addAttribute("mobileNumber", customer.getMobileNumber());
        return "viewProfile";
    }


    @RequestMapping("/updateProfile")
    public String updateProfile(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("customer",customerService.findById(principal.getName()));
        return "updateProfile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(Principal principal, HttpServletRequest req, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        Customer customer=customerService.findById(principal.getName());
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        Long mobileNumber=Long.parseLong(req.getParameter("mobileNumber"));
        //passenger.getUserName();
        customer.setName(name);
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobileNumber(mobileNumber);
        customerService.save(customer);
        return "redirect:/viewProfile";
    }

}

