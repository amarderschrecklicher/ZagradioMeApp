package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;
import java.util.Set;

import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleDto;

public record AccidentReportDto(
    long id,
    String description,    
    String status,    
    String media,
    String location,
    LocalDateTime timestamp,
    Set<VehicleDto> vehicles

) {
}
