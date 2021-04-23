package com.blum.restaurantapp.service;

import com.blum.restaurantapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantsService {
    @Autowired
    private RestaurantRepository restaurantRepo;
}
