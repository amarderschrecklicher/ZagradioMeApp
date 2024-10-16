package com.zagradio.me.zagradio_me_back.rest.dto.report;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleDto;

import java.time.LocalDateTime;
import java.util.Set;


public class ParkingReportDto extends ReportDto{

    private Set<VehicleDto> vehicles;
}