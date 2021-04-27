package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Tables;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablesRepository extends JpaRepository<Tables,Long> {

    @Override
    Tables getOne(Long aLong);

    @Override
    void delete(Tables tables);
}
