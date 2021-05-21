package com.blum.restaurantapp.models;

import javax.persistence.*;


@Entity
@Table(name = "tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private int seats;

    public Tables(Long id, int seats, Reservations reservations, Restaurants restaurants){
        this.id = id;
        this.seats = seats;
        this.reservations = reservations;
        this.restaurants = restaurants;
    }

    @OneToOne(mappedBy = "tables")
    private Reservations reservations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurants restaurants;

    public Tables() {

    }

    public Long getId() {
        return id;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", seats=" + seats +
                ", reservations=" + reservations +
                ", restaurants=" + restaurants +
                '}';
    }



    public int getSeats() {
        return seats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
