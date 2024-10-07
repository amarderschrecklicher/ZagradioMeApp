package com.zagradio.me.zagradio_me_back.rest.mapper;
import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleInfoDto;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleInfoDto vehicleToVehicleInfoDto(Vehicle vehicle);
    
}