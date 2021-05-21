package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.Restaurants;
import com.blum.restaurantapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class RestaurantsService {
    @Autowired
    private RestaurantRepository restaurantRepo;

    @Async
    public CompletableFuture<ArrayList<Restaurants>> getAllRestaurants(){
        ArrayList<Restaurants> list = new ArrayList<>();
        for (Restaurants restaurants: restaurantRepo.findAll()) {
            restaurants.setMeals(null);
            restaurants.setTables(null);
            restaurants.setSchedule(null);
            list.add(restaurants);
        }
        return CompletableFuture.completedFuture(list);
    }
}
