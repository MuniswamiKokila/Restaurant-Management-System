package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.Cart;

import com.project.RestaurantManagementSystem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> myCart(String userName) {
        return cartRepository.findByCustomerUserName(userName);
    }

    public void remove(Long id) {
        cartRepository.deleteById(id);
    }

    public void delete(){
        cartRepository.deleteAll();
    }

}
