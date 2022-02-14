package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.DineIn;

import com.project.RestaurantManagementSystem.repository.DineInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DineInService {
    @Autowired
    private DineInRepository dineInRepository;

    public List<DineIn> dineInList() {
        return dineInRepository.findAll();
    }

    public DineIn getByDineInId(Long id) {
        return dineInRepository.getById(id);
    }

    public void addDineIn(DineIn dineIn) {
        dineInRepository.save(dineIn);
    }

    public void removeDineInById(Long id) {
        dineInRepository.deleteById(id);
    }
}
