package com.project.RestaurantManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tables {
    @Id
    @GeneratedValue
    private Long id;
    private String tables;
    private double price;

    @JsonIgnore
    @ManyToOne
    public DineInShows dineInShows;

    public Tables(){}
    public Tables(String table,Double price){
        this.tables =table;
        this.price=price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DineInShows getDineInShows() {
        return dineInShows;
    }

    public void setDineInShows(DineInShows dineInShows) {
        this.dineInShows = dineInShows;
    }
}
