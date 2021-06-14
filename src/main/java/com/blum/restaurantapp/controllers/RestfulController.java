package com.blum.restaurantapp.controllers;

import com.blum.restaurantapp.component.IAuthenticationFacade;
import com.blum.restaurantapp.models.*;
import com.blum.restaurantapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class RestfulController {
    @Autowired
    private RestaurantsService restaurantsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ReservationMealsService reservationMealsService;

    @Autowired
    private TablesService tablesService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private MealsService mealsService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

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

    @GetMapping("/meals")
    public Meals getMealById(@RequestParam Long id){
        Meals meals = new Meals();
        try {
            meals = mealsService.getMealsById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return meals;
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
    public ArrayList<Reservations> getReservationsByTableId(@RequestParam Long id){
        ArrayList<Reservations> reservations = new ArrayList<>();
        try {
            reservations = reservationService.getReservationsByTableId(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

        }
        return reservations;
    }


    @PostMapping("/reservations/add")
    public Long addReservations(@RequestParam int table_id, @RequestParam Long from, @RequestParam Long to) throws ExecutionException, InterruptedException {
        Reservations reservations = new Reservations();
        Tables tables = tablesService.getTableById((long) table_id).get();
        String email = getCurrentUsername().get();
        Timestamp f = new Timestamp(from);
        Timestamp t = new Timestamp(to);
        Users user = usersService.getUser(email).get();
        reservations.setTables(tables);
        reservations.setUsers(user);
        reservations.setReservedTo(t);
        reservations.setReservedFrom(f);
        Long systemtime = System.currentTimeMillis();
        Timestamp current = new Timestamp(systemtime);
        reservations.setDate(current);
        reservationService.setReservations(reservations);

        return systemtime;
    }

    @GetMapping("/reservations/date/get")
    public Long getReservationByDate(@RequestParam Long curr_time) throws ExecutionException, InterruptedException {
        return reservationService.getReservationsByDate(new Timestamp(curr_time)).get().getId();
    }

    @PostMapping("/reservationmeals/add")
    public void addReservationMeals(@RequestParam Long reservation_id,@RequestParam Long meal_id) throws ExecutionException, InterruptedException {
        Reservations reservations = reservationService.getReservationsById(reservation_id).get();
        Meals meals = mealsService.getMealsById(meal_id).get();
        ReservationMeals reservationMeals = new ReservationMeals();
        reservationMeals.setMeals(meals);
        reservationMeals.setReservations(reservations);
        reservationMealsService.setReservationMeals(reservationMeals);
    }

    @Async
    public CompletableFuture<String> getCurrentUsername(){
        Authentication authentication = authenticationFacade.getAuthentication();
        return CompletableFuture.completedFuture(authentication.getName());
    }
}
