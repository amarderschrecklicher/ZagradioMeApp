package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;

public record ParkingReportInfoDto(
    long id,
    String description,    
    String status,    
    Vehicle vehicle,
    String photo,
    String location,
    LocalDateTime dateOfReport

) {
}
