package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface ReservationsRepository extends JpaRepository<Reservations,Long> {
    @Override
    Reservations getOne(Long aLong);

    ArrayList<Reservations> getAllByUsersId(Long users_id);

    @Override
    void delete(Reservations reservations);

    ArrayList<Reservations> getAllByTablesId(Long table_id);


    Reservations getByDate(Timestamp date);

    Reservations getById(Long id);
}
