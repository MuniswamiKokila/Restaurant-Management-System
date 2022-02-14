package com.project.RestaurantManagementSystem.repository;

import com.project.RestaurantManagementSystem.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TablesRepository extends JpaRepository<Tables,Long> {
    public Tables getByTables(String tables);
    public List<Tables> findByDineInShowsId(Long id);
}
