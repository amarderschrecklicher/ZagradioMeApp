package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.enums.CrimeType;

public record CrimeReportDto(
    long id,
    String description,    
    String status,    
    String photo,
    String location,
    LocalDateTime dateOfReport,
    CrimeType crimeType

) {
    
}
