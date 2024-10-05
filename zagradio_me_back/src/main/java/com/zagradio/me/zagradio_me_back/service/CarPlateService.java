package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateInfoDto;

import jakarta.validation.Valid;

public interface CarPlateService {

    public CarPlateInfoDto getCarPlateInfo(long id);

    public CarPlateInfoDto createCarPlate(@Valid CarPlateCreateDto carPlateCreateDto);

    public CarPlateInfoDto updateCarPlate(long id, @Valid CarPlateCreateDto carPlateCreateDto);

    public void deleteCarPlate(long id);
    
}
