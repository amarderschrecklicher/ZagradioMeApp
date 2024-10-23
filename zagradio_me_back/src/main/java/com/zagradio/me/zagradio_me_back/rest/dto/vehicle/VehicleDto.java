package com.zagradio.me.zagradio_me_back.rest.dto.vehicle;

import com.zagradio.me.zagradio_me_back.entity.User;

public record VehicleDto (
    long id,
    String name,
    String plateString,
    User user

) { 
}