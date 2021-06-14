package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Meals;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MealsRepository extends JpaRepository<Meals,Long> {
    @Override
    Meals getOne(Long aLong);

    @Override
    void delete(Meals meals);

    ArrayList<Meals> getAllByRestaurantsId(Long id);

    Meals getById(Long id);
}
