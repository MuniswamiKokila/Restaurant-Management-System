package com.project.RestaurantManagementSystem.repository;

import com.project.RestaurantManagementSystem.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    public List<Cart> findByCustomerUserName(String userName);
}
