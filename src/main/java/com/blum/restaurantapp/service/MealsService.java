package com.blum.restaurantapp.service;

import com.blum.restaurantapp.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealsService {
    @Autowired
    private MealsRepository mealsRepo;
}
