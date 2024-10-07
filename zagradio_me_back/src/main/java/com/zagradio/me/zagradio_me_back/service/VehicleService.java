package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleInfoDto;

import jakarta.validation.Valid;

public interface VehicleService {

    public VehicleInfoDto getVehicleInfo(long id);

    public VehicleInfoDto createVehicle(@Valid VehicleCreateDto vehicleCreateDto);

    public VehicleInfoDto updateVehicle(long id, @Valid VehicleCreateDto vehicleCreateDto);

    public void deleteVehicle(long id);
    
}
