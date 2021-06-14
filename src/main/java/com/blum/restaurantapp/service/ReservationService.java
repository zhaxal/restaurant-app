package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.repository.ReservationsRepository;
import com.blum.restaurantapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public void setReservations(Reservations reservations){
        reservationsRepo.save(reservations);
    }


    @Async
    public CompletableFuture<Reservations> getReservationsByDate(Timestamp timestamp){
        Reservations reservations = reservationsRepo.getByDate(timestamp);
        return CompletableFuture.completedFuture(reservations);
    }

    @Async
    public CompletableFuture<Reservations> getReservationsById(Long id){
        Reservations reservations = reservationsRepo.getById(id);
        return CompletableFuture.completedFuture(reservations);
    }

    @Async
    public CompletableFuture<ArrayList<Reservations>> getReservationsByTableId(Long id){
        ArrayList<Reservations> list = new ArrayList<>();
        for (Reservations reservations: reservationsRepo.getAllByTablesId(id)){
            reservations.setUsers(null);
            reservations.setTables(null);
            reservations.setReservationMeals(null);
            list.add(reservations);
        }
        return CompletableFuture.completedFuture(list);
    }
}
