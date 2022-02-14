package com.project.RestaurantManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
public class DineInShows {
    @Id
    @GeneratedValue
    public Long id;
    public Time time;
    @JsonIgnore
    @ManyToOne
    public DineIn dineIn;
    @OneToMany(mappedBy = "dineInShows")
    public List<Tables> tables;

    public DineInShows(){}
    public DineInShows(Time time){
        this.time=time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public DineIn getDineIn() {
        return dineIn;
    }

    public void setDineIn(DineIn dineIn) {
        this.dineIn = dineIn;
    }
}
