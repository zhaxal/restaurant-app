package com.blum.restaurantapp.models;

import javax.persistence.*;


@Entity
@Table(name = "meals")
public class Meals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurants restaurants;

    private boolean availability;
    private String name;
    private String description;
    private int price;

    @OneToOne(mappedBy = "meals")
    private ReservationMeals reservationMeals;

    public Long getId() {
        return id;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReservationMeals(ReservationMeals reservationMeals) {
        this.reservationMeals = reservationMeals;
    }

    public ReservationMeals getReservationMeals() {
        return reservationMeals;
    }
}
