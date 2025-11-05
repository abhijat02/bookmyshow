package com.bookmyshow.bookmyshow.model;


import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Theatre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Showtime> showtimes;

    public Theatre() {}

    public Theatre(String name, String location){
        this.name = name;
        this.location = location;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public List<Showtime> getShowtimes(){
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes){
        this.showtimes = showtimes;
    }
}
