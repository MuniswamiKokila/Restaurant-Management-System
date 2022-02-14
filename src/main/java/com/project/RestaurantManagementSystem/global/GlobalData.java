package com.project.RestaurantManagementSystem.global;

import com.project.RestaurantManagementSystem.entity.Food;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Food> cart;
    static {
        cart = new ArrayList<Food>();

    }
}
