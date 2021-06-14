package com.blum.restaurantapp.models;




import javax.persistence.*;
@Entity
@Table(name = "reservation_meals")
public class ReservationMeals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservations reservations;

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private Meals meals;

    public Meals getMeals() {
        return meals;
    }

    public Long getId() {
        return id;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }
}
