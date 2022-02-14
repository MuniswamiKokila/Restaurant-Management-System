package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.Food;
import com.project.RestaurantManagementSystem.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> foodList(){
        return foodRepository.findAll();
    }

    public Food getById(Long id) {
        return foodRepository.getById(id);
    }

    public void addMenu(Food menu) {
        foodRepository.save(menu);
    }

    public void removeFoodById(Long id) {
        foodRepository.deleteById(id);
    }

    public Optional<Food> getProductById(long id)
    {
        return foodRepository.findById(id);
    }
}
