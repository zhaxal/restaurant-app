package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Meals;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepository extends JpaRepository<Meals,Long> {
}
