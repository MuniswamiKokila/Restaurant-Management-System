package com.project.RestaurantManagementSystem.controller;

import com.project.RestaurantManagementSystem.entity.*;
import com.project.RestaurantManagementSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DineInService dineInService;
    @Autowired
    private DineInShowsService dineInShowsService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private TablesService tablesService;

    @RequestMapping("/adminRestaurant")
    public String adminRestaurant(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        return "adminRestaurant";
    }


//    ADMIN DINEIN PART

    @RequestMapping("/viewDineIn")
    public String viewDineInDate(Principal principal,HttpServletRequest request,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
       model.addAttribute("adminDineIn", dineInService.dineInList());
        return "viewDineIn";
    }

    @RequestMapping("/viewDineIn/add")  //dineIn/view
    public String addDineInDate(Principal principal,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("dineIn",new DineIn());
        return "addDineIn";
    }

    @PostMapping("viewDineIn/add")
    public String addDineIn(Principal principal,@ModelAttribute("dineIn") DineIn dineIn,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        dineInService.addDineIn(dineIn);
        return "redirect:/viewDineIn";
    }



    @GetMapping("/viewDineInTime/{id}")
    public String viewDineInTime(Principal principal,@PathVariable Long id,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("dineIn",dineInService.getByDineInId(id));
        model.addAttribute("adminTime", dineInShowsService.showDetails(id));
        return "viewDineInTime";
    }
    @RequestMapping("/addDineInTime/{id}")
    public String addDineInDateTime(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }

        model.addAttribute("dineInShows",id);
        model.addAttribute("shows",new DineInShows());
        return "addDineInTime";
    }
    @PostMapping("/addDineInTime/{id}")
    public String addDineInTime(Principal principal,Model model,@ModelAttribute("shows") DineInShows shows){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
//        model.addAttribute("dineIn",id);
        dineInShowsService.addDineInShows(shows);
        return "redirect:/viewDineIn";
    }


    @GetMapping("/viewTables/{id}")
    public String viewTables(Principal principal,@PathVariable Long id,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
//        model.addAttribute("dineIn",dineInService.getByDineInId(id));
        Tables tables=new Tables();
        tables.setDineInShows(dineInShowsService.getById(id));
        model.addAttribute("dineInShows",dineInShowsService.getById(id));
        model.addAttribute("adminTable",tablesService.showDetails(id));
        return "viewTables";
    }
    @RequestMapping("/addTables/{id}")
    public String addTables(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("tables",id);
        model.addAttribute("table",new Tables());
        return "addTables";
    }

    @PostMapping("/addTables/{id}")
    public String addTables(Principal principal,Model model,@ModelAttribute("table") Tables table){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        tablesService.addTables(table);
        return "redirect:/viewDineIn";
    }

    @GetMapping("/viewDineIn/delete/{id}")
    public String deleteDineInDate(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        dineInService.removeDineInById(id);
        return "redirect:/viewDineIn";
    }

    @GetMapping("/viewDineInTime/delete/{id}")
    public String deleteDineInTime(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        dineInShowsService.removeDineInTimeById(id);
//        dineInService.removeDineInById(id);
        return "redirect:/viewDineIn";
    }

    @GetMapping("/viewTables/delete/{id}")
    public String deleteTable(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        tablesService.removeTablesById(id);
//        dineInShowsService.removeDineInTimeById(id);
//        dineInService.removeDineInById(id);
        return "redirect:/viewDineIn";
    }







    
//    ADMIN TAKEAWAY

    @GetMapping("/viewMenu")
    public String viewMenu(Principal principal,HttpServletRequest request, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("adminmenu", foodService.foodList());
        return "viewMenu";
    }

    @RequestMapping("/updateMenu/add")
    public String updateMenu(Principal principal,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("menu",new Food());
        return "updateMenu";
    }
    @PostMapping("/updateMenu/add")
    public String updateMenu(Principal principal,Model model,@ModelAttribute("menu") Food menu){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        foodService.addMenu(menu);
        return "redirect:/viewMenu";
    }

    @GetMapping("/viewMenu/delete/{id}")
    public String deleteFood(Principal principal,@PathVariable Long id,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        foodService.removeFoodById(id);
        return "redirect:/viewMenu";
    }
}

