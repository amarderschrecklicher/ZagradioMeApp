package com.zagradio.me.zagradio_me_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleInfoDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.VehicleMapper;
import com.zagradio.me.zagradio_me_back.service.VehicleService;

import jakarta.validation.Valid;

public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepo vehicleRepo, VehicleMapper vehicleMapper) {
        this.vehicleRepo= vehicleRepo;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleInfoDto getVehicleInfo(long id) {
        return vehicleMapper.vehicleToVehicleInfoDto(vehicleRepo.findVehicleById(id));
    }

    @Override
    public VehicleInfoDto createVehicle(@Valid VehicleCreateDto vehicleCreateDto) {
        Vehicle newVehicle = Vehicle.builder()
        .plateString(vehicleCreateDto.plateString())
        .name(vehicleCreateDto.name())
        .user(vehicleCreateDto.user()).build();
        newVehicle = vehicleRepo.save(newVehicle);

        return vehicleMapper.vehicleToVehicleInfoDto(newVehicle);
    }

    @Override
    public VehicleInfoDto updateVehicle(long id, @Valid VehicleCreateDto vehicleCreateDto) {

        Vehicle existingVehicle = vehicleRepo.findVehicleById(id);

        existingVehicle.setPlateString(vehicleCreateDto.plateString());
        existingVehicle.setName(vehicleCreateDto.name());
        existingVehicle.setUser(vehicleCreateDto.user());

        Vehicle newVehicle =vehicleRepo.save(existingVehicle);

        return vehicleMapper.vehicleToVehicleInfoDto(newVehicle);
    }

    @Override
    public void deleteVehicle(long id) {
        vehicleRepo.deleteVehicleById(id);
    }
}
