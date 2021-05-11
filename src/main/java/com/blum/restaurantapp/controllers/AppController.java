package com.blum.restaurantapp.controllers;

import com.blum.restaurantapp.models.ReservationMeals;
import com.blum.restaurantapp.models.Reservations;
import com.blum.restaurantapp.models.Users;
import com.blum.restaurantapp.service.ReservationMealsService;
import com.blum.restaurantapp.service.ReservationService;
import com.blum.restaurantapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import com.blum.restaurantapp.component.IAuthenticationFacade;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
public class AppController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationMealsService reservationMealsService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/testdb")
    public String showMyQuestionsAndAnswers(Model model) throws ExecutionException, InterruptedException {

        return usersService.getUser(0L).get().toString();
    }

    @GetMapping("/profile")
    public String showMyUserAndReservations(Model model) {
        try {
            String email = getCurrentUsername().get();
            Users user = usersService.getUser(email).get();
            model.addAttribute("user",user);
            ArrayList<Reservations> reservations = reservationService.getReservations(email).get();
            ArrayList<ReservationMeals> reservationMeals = new ArrayList<>();
            for (Reservations reservation : reservations) {
                ArrayList<ReservationMeals> oneReservationMeals = reservationMealsService.getReservationMeals(reservation.getId()).get();
                for (ReservationMeals reservationMeals1: oneReservationMeals) {
                    reservationMeals.add(reservationMeals1);
                }
            }
            model.addAttribute("reservations", reservations);
            model.addAttribute("reservationMeals", reservationMeals);


        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return "profile";
    }

    @Async
    public CompletableFuture<String> getCurrentUsername(){
        Authentication authentication = authenticationFacade.getAuthentication();
        return CompletableFuture.completedFuture(authentication.getName());
    }
}
