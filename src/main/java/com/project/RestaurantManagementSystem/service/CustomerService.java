package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.Customer;
import com.project.RestaurantManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Boolean existsById(String userName){
        return customerRepository.existsById(userName);
    }

    public Customer findCustomerByUserName(String userName){
        return customerRepository.getById(userName);
    }
}
