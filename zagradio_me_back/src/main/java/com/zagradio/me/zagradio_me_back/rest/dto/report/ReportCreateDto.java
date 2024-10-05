package com.zagradio.me.zagradio_me_back.rest.dto.report;

import jakarta.validation.constraints.NotBlank;

public record ReportCreateDto(

    @NotBlank(message = "Car plates number is mandatory")
    String carPlates,

    @NotBlank(message = "Description is mandatory")
    String description,

    @NotBlank(message = "Photo is mandatory")
    String photo,

    @NotBlank(message = "Location is mandatory")
    String location


) {
}