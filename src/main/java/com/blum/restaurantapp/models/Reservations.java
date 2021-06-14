package com.blum.restaurantapp.models;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "reservations",fetch = FetchType.EAGER)
    private Set<ReservationMeals> reservationMeals;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    private Timestamp date;
    private Timestamp reservedFrom;
    private Timestamp reservedTo;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private Tables tables;

    public Tables getTables() {
        return tables;
    }



    public Long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public Timestamp getReservedFrom() {
        return reservedFrom;
    }

    public Timestamp getReservedTo() {
        return reservedTo;
    }

    public Users getUsers() {
        return users;
    }

    public Set<ReservationMeals> getReservationMeals() {
        return reservationMeals;
    }

    public void setReservationMeals(Set<ReservationMeals> reservationMeals) {
        this.reservationMeals = reservationMeals;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setReservedFrom(Timestamp reservedFrom) {
        this.reservedFrom = reservedFrom;
    }

    public void setReservedTo(Timestamp reservedTo) {
        this.reservedTo = reservedTo;
    }


}
