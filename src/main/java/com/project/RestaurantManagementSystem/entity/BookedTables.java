package com.project.RestaurantManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class BookedTables {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String tables;
    private Double tablePrice;
    @JsonIgnore
    @ManyToOne
    private Customer customer;
    @JsonIgnore
    @ManyToOne
    private DineInShows dineInShows;


    public BookedTables(){}
    public BookedTables(String tables,Double tablePrice){
        this.tables=tables;
        this.tablePrice=tablePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public Double getTablePrice() {
        return tablePrice;
    }

    public void setTablePrice(Double tablePrice) {
        this.tablePrice = tablePrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DineInShows getDineInShows() {
        return dineInShows;
    }

    public void setDineInShows(DineInShows dineInShows) {
        this.dineInShows = dineInShows;
    }
}
