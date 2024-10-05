package com.zagradio.me.zagradio_me_back.rest.dto.car_plate;

import com.zagradio.me.zagradio_me_back.entity.User;

public record CarPlateInfoDto (
    long id,
    String plateNumber,
    String vehicle,
    User user

) { 
}
