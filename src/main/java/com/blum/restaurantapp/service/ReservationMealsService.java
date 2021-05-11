package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.ReservationMeals;
import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.repository.ReservationMealsRepository;
import com.blum.restaurantapp.repository.ReservationsRepository;
import com.blum.restaurantapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class ReservationMealsService {
    @Autowired
    private ReservationMealsRepository reservationMealsRepo;

    @Autowired
    private ReservationsRepository reservationsRepo;

    @Async
    public CompletableFuture<ArrayList<ReservationMeals>> getReservationMeals(Long reservation_id){
        ArrayList<ReservationMeals> list = new ArrayList<>();
        for (ReservationMeals reservationMeals: reservationMealsRepo.getAllByReservationsId(reservation_id)) {
            list.add(reservationMeals);
        }
        return CompletableFuture.completedFuture(list);
    }
}
