package com.blum.restaurantapp.service;

import com.blum.restaurantapp.repository.ReservationMealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationMealsService {
    @Autowired
    private ReservationMealsRepository reservationMealsRepo;
}
