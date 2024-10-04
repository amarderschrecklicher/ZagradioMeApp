package com.zagradio.me.zagradio_me_back.rest.dto.user;

import java.time.LocalDate;

public record UserInfoDto(
    long id,
    String email,
    String firstName,
    String lastName,
    LocalDate dateOfBirth
) {
}
