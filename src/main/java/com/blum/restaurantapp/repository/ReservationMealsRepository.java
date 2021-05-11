package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.ReservationMeals;
import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ReservationMealsRepository extends JpaRepository<ReservationMeals,Long> {
    @Override
    ReservationMeals getOne(Long aLong);

    ArrayList<ReservationMeals> getAllByReservationsId(Long reservation_id);


    @Override
    void delete(ReservationMeals reservationMeals);
}
