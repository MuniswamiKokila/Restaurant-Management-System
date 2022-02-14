package com.project.RestaurantManagementSystem.service;

import com.project.RestaurantManagementSystem.entity.BookedTables;


import com.project.RestaurantManagementSystem.repository.BookedTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookedTableService {
    @Autowired
    private BookedTablesRepository bookedTablesRepository;

    public BookedTables getByTablesAndDineInShowsId(String tables, Long id) {
        return bookedTablesRepository.getByTablesAndDineInShowsId(tables,id);
    }

    public BookedTables saveTable(BookedTables bookedTables) {
        return bookedTablesRepository.save(bookedTables);
    }

    public List<BookedTables> findByCustomerUserName(String userName) {
        return bookedTablesRepository.findByCustomerUserName(userName);
    }
}
