package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.CarPlate;

public interface CarPlateRepo extends JpaRepository<CarPlate, Integer>  {

    @Query("SELECT cp FROM CarPlate cp WHERE cp.id = :id")
    CarPlate findCarPlateById(@Param("id") long id);

    @Query("DELETE FROM CarPlate cp WHERE cp.id = :id")
    CarPlate deleteCarPlateById(@Param("id") long id);
}
