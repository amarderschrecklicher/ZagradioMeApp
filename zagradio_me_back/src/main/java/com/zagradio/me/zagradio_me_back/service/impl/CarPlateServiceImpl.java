package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.repository.CarPlateRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateInfoDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.CarPlateMapper;
import com.zagradio.me.zagradio_me_back.service.CarPlateService;

import jakarta.validation.Valid;

public class CarPlateServiceImpl implements CarPlateService {


    private final CarPlateRepo carPlateRepo;
    private final CarPlateMapper carPlateMapper;

    public CarPlateServiceImpl(CarPlateRepo carPlateRepo, CarPlateMapper carPlateMapper) {
        this.carPlateRepo= carPlateRepo;
        this.carPlateMapper = carPlateMapper;
    }

    @Override
    public CarPlateInfoDto getCarPlateInfo(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarPlateInfo'");
    }

    @Override
    public CarPlateInfoDto createCarPlate(@Valid CarPlateCreateDto carPlateCreateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCarPlate'");
    }

    @Override
    public CarPlateInfoDto updateCarPlate(long id, @Valid CarPlateCreateDto carPlateCreateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCarPlate'");
    }

    @Override
    public void deleteCarPlate(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCarPlate'");
    }
    
}
