package com.project.RestaurantManagementSystem.repository;

import com.project.RestaurantManagementSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
