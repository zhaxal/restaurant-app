package com.blum.restaurantapp.service;

import com.blum.restaurantapp.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationsRepository reservationsRepo;
}
