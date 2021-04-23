package com.blum.restaurantapp.repository;

import com.blum.restaurantapp.models.Schedule;
import com.blum.restaurantapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
