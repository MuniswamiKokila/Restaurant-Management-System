package com.project.RestaurantManagementSystem.controller;

import com.project.RestaurantManagementSystem.entity.*;
import com.project.RestaurantManagementSystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.Objects;

@Controller
public class DineInController {
    @Autowired
    public DineInService dineInService;
    @Autowired
    public DineInShowsService dineInShowsService;
    @Autowired
    public CustomerService customerService;
    @Autowired
    public TablesService tableService;
    @Autowired
    private BookedTableService bookedTableService;


//    USER DINEIN
    @RequestMapping("/dineIn")
    public String DineIn(Principal principal,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("dineIns", dineInService.dineInList());
        return "dineIn";
    }


    @GetMapping("/{userName}/dineInShows/{id}")
    public String DineInShows(Principal principal,@PathVariable Long id,Model model,@PathVariable String userName){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("dineIn",dineInService.getByDineInId(id));
        model.addAttribute("shows", dineInShowsService.showDetails(id));
        return "dineInShows";
    }


    @GetMapping("/{userName}/tables/{id}")
    public String tables(Principal principal,@PathVariable String userName, @PathVariable Long id,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("shows",id);
        model.addAttribute("userName",userName);
        return "tables";
    }


    @RequestMapping("/booked")
    public String booked(Principal principal,@PathVariable String userName,@PathVariable Long shows,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("userName",userName);
        model.addAttribute("shows",shows);
        return "booked";
    }

    @PostMapping("/{userName}/booked/{shows}")
    public String tableBooked(Principal principal,@PathVariable String userName,@PathVariable Long shows, HttpServletRequest request, Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        String bookTables = request.getParameter("bookedTables");
        String[] bookedTable = bookTables.split(",");
        for(String table : bookedTable) {
            BookedTables bookedTables=bookedTableService.getByTablesAndDineInShowsId(table, shows);
            if (!(Objects.isNull(bookedTables))){
                model.addAttribute("message"," Table is already booked. Please Choose another Table");
                return "tables";
            }
        }
        for (String table : bookedTable) {
            System.out.println(table);
            Tables tables=tableService.getBySeats(table,shows);
            BookedTables bookedTables=new BookedTables(tables.getTables(),tables.getPrice());
            bookedTables.setDineInShows(dineInShowsService.getById(shows));
            bookedTables.setCustomer(customerService.findCustomerByUserName(userName));
            model.addAttribute("name",bookedTables.getCustomer().getName());
            model.addAttribute("date",bookedTables.getDineInShows().getDineIn().getDate());
            model.addAttribute("time",bookedTables.getDineInShows().getTime());
            model.addAttribute("tables",bookedTable);
            model.addAttribute("price", Arrays.stream(bookedTable).count()*150);
            bookedTableService.saveTable(bookedTables);
            model.addAttribute("message","Table booked successfully... You can see your bookings here...");
        }
        return "booked";
    }

    @GetMapping("/{userName}/myBookings")
    public String myBookings(Principal principal,@PathVariable String userName, Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("userName",bookedTableService.findByCustomerUserName(userName));
        return "myBookings";
    }



}
