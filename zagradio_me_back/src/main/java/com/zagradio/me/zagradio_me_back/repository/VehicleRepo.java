package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>  {

    @Query("SELECT v FROM Vehicle v WHERE v.id = :id")
    Vehicle findVehicleById(@Param("id") long id);


    @Query("DELETE FROM Vehicle v WHERE v.id = :id")
    Vehicle deleteVehicleById(@Param("id") long id);

    
}
