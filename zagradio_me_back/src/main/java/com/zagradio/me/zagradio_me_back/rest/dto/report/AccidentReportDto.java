package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;
import java.util.List;

import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleCreateDto;

public record AccidentReportDto(
    long id,
    String description,    
    String status,    
    String photo,
    String location,
    LocalDateTime dateOfReport,
    List<VehicleCreateDto> vehicles

) {
}
