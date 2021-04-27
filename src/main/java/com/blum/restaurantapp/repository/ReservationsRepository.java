package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<Reservations,Long> {
    @Override
    Reservations getOne(Long aLong);

    @Override
    void delete(Reservations reservations);
}
