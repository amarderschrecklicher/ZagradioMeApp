package com.zagradio.me.zagradio_me_back.rest.mapper;
import java.util.Set;
import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleDto;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDto vehicleToVehicleDto(Vehicle vehicle);

    Set<Vehicle> vehicleSetToVehicleDtoSet(Set<VehicleDto> vehicles);
    
}