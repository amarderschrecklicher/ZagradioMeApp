package com.zagradio.me.zagradio_me_back.rest.dto.user;

import java.time.LocalDate;
import java.util.List;
import com.zagradio.me.zagradio_me_back.entity.Vehicle;

public record UserInfoDto(
    long id,
    String email,
    String firstName,
    String lastName,
    LocalDate dateOfBirth,
    List<Vehicle> vehicles
) {
}
