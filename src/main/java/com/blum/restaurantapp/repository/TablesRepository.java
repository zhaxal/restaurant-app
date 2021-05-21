package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Tables;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface TablesRepository extends JpaRepository<Tables,Long> {

    @Override
    Tables getOne(Long aLong);

    @Override
    void delete(Tables tables);

    @Override
    List<Tables> findAll();

    List<Tables> getByRestaurants_Id(Long id);
}
