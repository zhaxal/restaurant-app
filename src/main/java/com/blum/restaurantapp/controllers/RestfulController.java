package com.blum.restaurantapp.controllers;

import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.models.Restaurants;
import com.blum.restaurantapp.models.Tables;
import com.blum.restaurantapp.service.ReservationService;
import com.blum.restaurantapp.service.RestaurantsService;
import com.blum.restaurantapp.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class RestfulController {
    @Autowired
    private RestaurantsService restaurantsService;

    @Autowired
    private TablesService tablesService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/restaurants/get/all")
    public ArrayList<Restaurants> getRestaurantList(){
        ArrayList<Restaurants> restaurants = new ArrayList<>();
        try {
            restaurants = restaurantsService.getAllRestaurants().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @GetMapping("/table/restaurant/get")
    public ArrayList<Tables> getTableByRestaurantId(@RequestParam Long id){
        ArrayList<Tables> tables = new ArrayList<>();
        try {
            tables = tablesService.getTablesById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return tables;
    }

    @GetMapping("/reservations/table/get")
    public Reservations getReservationsByTableId(@RequestParam Long id){
        Reservations reservations = new Reservations();
        try {
            reservations = reservationService.getReservationsByTableId(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
