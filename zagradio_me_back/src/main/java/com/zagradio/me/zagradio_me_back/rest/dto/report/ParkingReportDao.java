package com.zagradio.me.zagradio_me_back.rest.dto.report;

import jakarta.validation.constraints.NotBlank;


import com.zagradio.me.zagradio_me_back.entity.Vehicle;

public record ParkingReportDao(

    @NotBlank(message = "Vehicle is mandatory")
    Vehicle vehicle,

    @NotBlank(message = "Photo is mandatory")
    String photo,

    @NotBlank(message = "Location is mandatory")
    String location

){
}