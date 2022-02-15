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
    public Tables getBySeats(String table,Long show){
        List<Tables> tables = tablesRepository.getByTables(table);
        for(Tables t:tables) {
            if (t.getDineInShows().getId() == show)
                return t;
        }
        return null;
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
    public void removeTablesById(Long id) {
        tablesRepository.deleteById(id);
    }
}
