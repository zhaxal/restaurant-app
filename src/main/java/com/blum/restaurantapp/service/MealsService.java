package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.Meals;
import com.blum.restaurantapp.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class MealsService {
    @Autowired
    private MealsRepository mealsRepo;

    @Async
    public CompletableFuture<ArrayList<Meals>> getMealsByRestaurantId(Long id){
        ArrayList<Meals> list = mealsRepo.getAllByRestaurantsId(id);
        return CompletableFuture.completedFuture(list);
    }

    @Async
    public CompletableFuture<Meals> getMealsById(Long id){
        Meals meals = mealsRepo.getById(id);
        meals.setRestaurants(null);
        meals.setReservationMeals(null);
        return CompletableFuture.completedFuture(meals);
    }
}
