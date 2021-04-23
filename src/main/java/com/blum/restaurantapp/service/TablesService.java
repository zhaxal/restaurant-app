package com.blum.restaurantapp.service;

import com.blum.restaurantapp.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepo;
}
