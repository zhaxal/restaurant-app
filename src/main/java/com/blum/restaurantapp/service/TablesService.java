package com.blum.restaurantapp.service;

import com.blum.restaurantapp.models.Tables;
import com.blum.restaurantapp.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepo;

    @Async
    public CompletableFuture<ArrayList<Tables>> getTablesById(Long id){
        ArrayList<Tables> list = new ArrayList<>();
        for (Tables tables: tablesRepo.getByRestaurants_Id(id)) {
            tables.setReservations(null);
            tables.setRestaurants(null);
            list.add(tables);
        }
        return CompletableFuture.completedFuture(list);
    }

    @Async
    public CompletableFuture<Tables> getTableById(Long id){
        Tables tables = new Tables();
        tables = tablesRepo.getById(id);
        return CompletableFuture.completedFuture(tables);
    }

    @Async
    public CompletableFuture<List<Tables>> getAllTables(){
        return CompletableFuture.completedFuture(tablesRepo.findAll());
    }
}
