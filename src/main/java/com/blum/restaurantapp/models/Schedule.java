package com.blum.restaurantapp.models;


import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private Timestamp date;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurants restaurants;

    public Long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }
}
