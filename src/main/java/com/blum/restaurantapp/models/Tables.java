package com.blum.restaurantapp.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private int seats;

    public Tables(Long id, int seats, Set<Reservations> reservations, Restaurants restaurants){
        this.id = id;
        this.seats = seats;
        this.reservations = reservations;
        this.restaurants = restaurants;
    }

    @OneToMany(mappedBy = "tables")
    private Set<Reservations> reservations;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Set<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservations> reservations) {
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
