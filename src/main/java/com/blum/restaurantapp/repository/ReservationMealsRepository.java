package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.ReservationMeals;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationMealsRepository extends JpaRepository<ReservationMeals,Long> {
}
