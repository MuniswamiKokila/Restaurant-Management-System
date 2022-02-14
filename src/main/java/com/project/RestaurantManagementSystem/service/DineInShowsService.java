package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.DineInShows;
import com.project.RestaurantManagementSystem.repository.DineInShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DineInShowsService {
    @Autowired
    public DineInShowsRepository dineInShowsRepository;
    public List<DineInShows> showDetails(Long id) {
        return dineInShowsRepository.findByDineInId(id);
    }

    public DineInShows getById(Long id) {
        return dineInShowsRepository.getById(id);
    }



    public void addDineInShows(DineInShows shows) {
        dineInShowsRepository.save(shows);
    }

    public void removeDineInTimeById(Long id) {
        dineInShowsRepository.deleteById(id);
    }
}
