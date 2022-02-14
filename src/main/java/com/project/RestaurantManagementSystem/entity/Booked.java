//package com.project.RestaurantManagementSystem.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Booked {
//    @Id
//    private Long id;
//    @JsonIgnore
//    @ManyToOne
//    private Customer customer;
//    @JsonIgnore
//    @ManyToOne
//    private DineInShows dineInShows;
//
//    public Booked(){}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public DineInShows getDineInShows() {
//        return dineInShows;
//    }
//
//    public void setDineInShows(DineInShows dineInShows) {
//        this.dineInShows = dineInShows;
//    }
//}
