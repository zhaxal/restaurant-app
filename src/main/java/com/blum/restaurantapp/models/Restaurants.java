package com.blum.restaurantapp.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "restaurants")
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;
    private String address;
    private double rating;
    private Timestamp openTime;
    private Timestamp closeTime;
    private double x;
    private double y;

    @OneToOne(mappedBy = "restaurants")
    private Schedule schedule;

    @OneToOne(mappedBy = "restaurants")
    private Meals meals;

    @OneToOne(mappedBy = "restaurants")
    private Tables tables;

    public Tables getTables() {
        return tables;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public Long getId() {
        return id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenTime(Timestamp openTime) {
        this.openTime = openTime;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Timestamp getOpenTime() {
        return openTime;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getRating() {
        return rating;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }
}

