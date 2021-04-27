package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    @Override
    Optional<Users> findById(Long aLong);

    Users findByEmail(String email);

    @Override
    void delete(Users users);
}
