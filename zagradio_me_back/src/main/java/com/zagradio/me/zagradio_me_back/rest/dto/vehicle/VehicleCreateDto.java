package com.zagradio.me.zagradio_me_back.rest.dto.vehicle;

import com.zagradio.me.zagradio_me_back.entity.User;

import jakarta.validation.constraints.NotBlank;

public record VehicleCreateDto(

    @NotBlank(message = "Name is mandatory")
    String name,

    @NotBlank(message = "Car plates is mandatory")
    String plateString,

    @NotBlank(message = "User is mandatory")
    User user

) { 

}
