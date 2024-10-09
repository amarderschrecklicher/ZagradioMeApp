package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record ReportCreateDto(   

    @NotBlank(message = "Description is mandatory")
    int reportType,

    @NotBlank(message = "Description is mandatory")
    String description,
    
    @NotBlank(message = "Report date is mandatory")
    LocalDateTime reportDate,

    @NotBlank(message = "Status is mandatory")
    String status
) {


}
