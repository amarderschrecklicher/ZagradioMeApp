package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.time.LocalDateTime;
import com.zagradio.me.zagradio_me_back.enums.EmergencyType;

public record SOSReportDao(
    long id,
    String description,    
    String status,    
    String photo,
    String location,
    LocalDateTime dateOfReport,
    EmergencyType emergencyType
) {
    
}
