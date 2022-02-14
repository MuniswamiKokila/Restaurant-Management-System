package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.Customer;
import com.project.RestaurantManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Boolean existsById(String userName){
        return customerRepository.existsById(userName);
    }

    public Customer findCustomerByUserName(String userName){
        return customerRepository.getById(userName);
    }

    public Customer findById(String userName) {
        return customerRepository.findById(userName).get();
    }

    public Customer updateCustomer(Customer existingCustomer) {
        return customerRepository.save(existingCustomer);
    }


    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }
}
