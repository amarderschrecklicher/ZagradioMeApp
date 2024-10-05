package com.zagradio.me.zagradio_me_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zagradio.me.zagradio_me_back.entity.CarPlate;
import com.zagradio.me.zagradio_me_back.repository.CarPlateRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateInfoDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.CarPlateMapper;
import com.zagradio.me.zagradio_me_back.service.CarPlateService;

import jakarta.validation.Valid;

public class CarPlateServiceImpl implements CarPlateService {

    @Autowired
    private final CarPlateRepo carPlateRepo;
    @Autowired
    private final CarPlateMapper carPlateMapper;

    public CarPlateServiceImpl(CarPlateRepo carPlateRepo, CarPlateMapper carPlateMapper) {
        this.carPlateRepo= carPlateRepo;
        this.carPlateMapper = carPlateMapper;
    }

    @Override
    public CarPlateInfoDto getCarPlateInfo(long id) {
        return carPlateMapper.carPlateToCarPlateInfoDto(carPlateRepo.findCarPlateById(id));
    }

    @Override
    public CarPlateInfoDto createCarPlate(@Valid CarPlateCreateDto carPlateCreateDto) {
        CarPlate newCarPlate = CarPlate.builder()
        .plateNumber(carPlateCreateDto.plateNumber())
        .vehicle(carPlateCreateDto.vehicle())
        .user(carPlateCreateDto.user()).build();
        newCarPlate = carPlateRepo.save(newCarPlate);

        return carPlateMapper.carPlateToCarPlateInfoDto(newCarPlate);
    }

    @Override
    public CarPlateInfoDto updateCarPlate(long id, @Valid CarPlateCreateDto carPlateCreateDto) {

        CarPlate existingCarPlate = carPlateRepo.findCarPlateById(id);

        existingCarPlate.setPlateNumber(carPlateCreateDto.plateNumber());
        existingCarPlate.setVehicle(carPlateCreateDto.vehicle());
        existingCarPlate.setUser(carPlateCreateDto.user());

        CarPlate newCarPlate =carPlateRepo.save(existingCarPlate);

        return carPlateMapper.carPlateToCarPlateInfoDto(newCarPlate);
    }

    @Override
    public void deleteCarPlate(long id) {
        carPlateRepo.deleteCarPlateById(id);
    }
}
