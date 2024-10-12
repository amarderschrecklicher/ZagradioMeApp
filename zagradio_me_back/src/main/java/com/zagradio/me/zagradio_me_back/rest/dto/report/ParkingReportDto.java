package com.zagradio.me.zagradio_me_back.rest.dto.report;

import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleCreateDto;
import java.time.LocalDateTime;
import java.util.List;

public record ParkingReportDto(

    long id,
    String description,    
    String status,    
    String photo,
    String location,
    LocalDateTime dateOfReport,
    List<VehicleCreateDto> vehicles

){
}