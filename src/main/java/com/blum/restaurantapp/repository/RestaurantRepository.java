package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Restaurants;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurants,Long> {

    @Override
    Restaurants getOne(Long aLong);

    @Override
    void delete(Restaurants restaurants);
}
