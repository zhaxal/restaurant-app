package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.models.Tables;
import com.blum.restaurantapp.repository.ReservationsRepository;
import com.blum.restaurantapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class ReservationService {
    @Autowired
    private ReservationsRepository reservationsRepo;

    @Autowired
    private UsersRepository usersRepository;

    @Async
    public CompletableFuture<ArrayList<Reservations>> getReservations(String email){
        ArrayList<Reservations> list = new ArrayList<>();
        for (Reservations reservation: reservationsRepo.getAllByUsersId(usersRepository.findByEmail(email).getId())) {
            list.add(reservation);
        }
        return CompletableFuture.completedFuture(list);
    }

    @Async
    public CompletableFuture<Reservations> getReservationsByTableId(Long id){
        Reservations reservations = reservationsRepo.getByTablesId(id);
        reservations.setUsers(null);
        reservations.setTables(null);
        reservations.setReservationMeals(null);
        return CompletableFuture.completedFuture(reservations);
    }
}
