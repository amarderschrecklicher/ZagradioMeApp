package com.zagradio.me.zagradio_me_back.rest.dto.car_plate;

import com.zagradio.me.zagradio_me_back.entity.User;

import jakarta.validation.constraints.NotBlank;

public record CarPlateCreateDto(

    @NotBlank(message = "Car plates number is mandatory")
    String plateNumber,

    @NotBlank(message = "Description is mandatory")
    String vehicle,

    @NotBlank(message = "Description is mandatory")
    User user

) { 

}
