package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDate;

public record ReportInfoDto(
    long id,
    String carPlates,
    String description,
    String photo,
    LocalDate dateOfReport
) {
}
