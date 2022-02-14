package com.project.RestaurantManagementSystem.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class DineIn {
    @Id
    @GeneratedValue
    public Long id;
    @Column(unique = true)
    public Date date;
    @OneToMany(mappedBy = "dineIn")
    public List<DineInShows> dineInShows;
    public DineIn(){}
    public DineIn(Date date){
        this.date=date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<DineInShows> getDineInShows() {
        return dineInShows;
    }

    public void setDineInShows(List<DineInShows> dineInShows) {
        this.dineInShows = dineInShows;
    }
}
