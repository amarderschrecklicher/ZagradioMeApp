package com.zagradio.me.zagradio_me_back.rest.mapper;
import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.CarPlate;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateInfoDto;

@Mapper(componentModel = "spring")
public interface CarPlateMapper {

    CarPlateInfoDto carPlateToCarPlateInfoDto(CarPlate carPlate);
    
}