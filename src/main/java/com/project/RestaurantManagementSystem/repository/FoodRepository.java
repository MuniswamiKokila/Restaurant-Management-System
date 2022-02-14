package com.project.RestaurantManagementSystem.repository;

import com.project.RestaurantManagementSystem.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
