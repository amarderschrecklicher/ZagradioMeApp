package com.zagradio.me.zagradio_me_back.rest.dto.report;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;

public record ReportCreateDto(

    @NotBlank(message = "Vehicle is mandatory")
    Vehicle vehicle,

    @NotBlank(message = "Description is mandatory")
    String description,

    @NotBlank(message = "Photo is mandatory")
    String photo,

    @NotBlank(message = "Location is mandatory")
    String location,
    
    @NotBlank(message = "Report date is mandatory")
    LocalDate reportDate,

    @NotBlank(message = "Status is mandatory")
    String status



) {
}