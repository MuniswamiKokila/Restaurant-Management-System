//package com.project.RestaurantManagementSystem.service;
//
//import com.project.RestaurantManagementSystem.entity.Booked;
//import com.project.RestaurantManagementSystem.entity.DineInShows;
//import com.project.RestaurantManagementSystem.repository.BookedRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.awt.print.Book;
//import java.sql.Time;
//
//@Service
//public class BookedService {
//    @Autowired
//    private BookedRepository bookedRepository;
//
//    public Booked getByDineInShowsTimeAndDineInId(Time time, Long id) {
//        return bookedRepository.getByDineInShowsTimeAndDineInId(time,id);
//
//    }
//
//    public void addDineInShows(DineInShows dineInShows) {
//        bookedRepository.save(dineInShows);
//    }
//}
