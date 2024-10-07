package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDate;

import com.zagradio.me.zagradio_me_back.entity.Vehicle;

public record ReportInfoDto(
    long id,
    Vehicle vehicle,
    String description,
    String photo,
    LocalDate dateOfReport,
    String status
) {
}
