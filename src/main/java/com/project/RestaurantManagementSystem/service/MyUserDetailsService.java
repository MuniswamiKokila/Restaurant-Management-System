package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.Customer;
import com.project.RestaurantManagementSystem.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    public CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user=customerService.findById(username);
        System.out.println(user.getUserName());
        return new MyUserDetails(user);
    }
}
