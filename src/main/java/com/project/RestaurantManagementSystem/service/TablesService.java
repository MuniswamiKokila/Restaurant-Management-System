package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.Tables;
import com.project.RestaurantManagementSystem.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepository;
    public Tables getBySeats(String tables){
        return tablesRepository.getByTables(tables);
    }

    public List<Tables> showDetails(Long id) {
        return tablesRepository.findByDineInShowsId(id);
    }

    public void addTables(Tables table) {
        tablesRepository.save(table);
    }
//    public DineInShows getById(Long id) {
//        return dineInShowsRepository.getById(id);
//    }
    public Tables getById(Long id){
        return tablesRepository.getById(id);
    }
}
