package com.project.RestaurantManagementSystem.controller;

import com.project.RestaurantManagementSystem.entity.Cart;
import com.project.RestaurantManagementSystem.entity.Customer;
import com.project.RestaurantManagementSystem.entity.Food;
import com.project.RestaurantManagementSystem.global.GlobalData;
import com.project.RestaurantManagementSystem.service.CartService;
import com.project.RestaurantManagementSystem.service.CustomerService;
import com.project.RestaurantManagementSystem.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class OrderController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;
    //    USER TAKEAWAY

    @RequestMapping("/menu")
    public String viewMenu(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("usermenu", foodService.foodList());
        return "menu";
    }
    @GetMapping("/{userName}/added/{id}")
    public String cart(Principal principal, @PathVariable String userName,@PathVariable Long id, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("userName",userName);
        Food food = foodService.getById(id);
        Customer customer = customerService.findCustomerByUserName(userName);
        model.addAttribute("food", food);
        Cart cart = new Cart();
        cart.setFood(food);
        cart.setCustomer(customer);
        cartService.addToCart(cart);
//        model.addAttribute("cart.food.name",cart.getFood().getName());
        model.addAttribute("mycart",cartService.myCart(userName));
        return "Added";
    }

    @GetMapping("/{userName}/cart")
    public String myCart(Principal principal,@PathVariable String userName,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("userName",userName);
        model.addAttribute("mycart",cartService.myCart(userName));
        return "cart";
    }

    @GetMapping("/{userName}/cart/delete/{id}")
    public String removeFromCart(Principal principal,@PathVariable Long id,@PathVariable String userName,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("userName",userName);
        cartService.remove(id);
        return "redirect:/menu";
    }
    @RequestMapping("/checkout")
    public String checkout(Model model,Principal principal){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        return "payNow";

    }

}
