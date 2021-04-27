package com.blum.restaurantapp.controllers;

import com.blum.restaurantapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class AppController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/testdb")
    public String showMyQuestionsAndAnswers(Model model) throws ExecutionException, InterruptedException {

        return usersService.getUser(0L).get().toString();
    }
}
