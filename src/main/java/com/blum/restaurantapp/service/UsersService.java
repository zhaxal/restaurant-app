package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.Users;
import com.blum.restaurantapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepo;

    @Async
    public CompletableFuture<Users> getUser(Long id){
        Users user = usersRepo.findById(id).get();

        return CompletableFuture.completedFuture(user);
    }

    @Async
    public CompletableFuture<Users> getUser(String email){
        Users user = usersRepo.findByEmail(email);

        return CompletableFuture.completedFuture(user);
    }

}
