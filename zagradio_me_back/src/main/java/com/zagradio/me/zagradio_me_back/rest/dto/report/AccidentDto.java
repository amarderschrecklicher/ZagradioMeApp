package com.zagradio.me.zagradio_me_back.rest.dto.report;

import java.util.Set;
import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleDto;

public class AccidentDto extends ReportDto {

    private Set<VehicleDto> vehicles;  // Specific to accident reports

    public AccidentDto() {
        super();
    }

    public AccidentDto(long id,String description, String location, String status,String media, LocalDateTime timestamp, Set<VehicleDto> vehicles) {
        super(id,description, location, status, media, timestamp);
        this.vehicles = vehicles;
    }

    public Set<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "AccidentReportDto{" +
                "vehicles=" + vehicles +
                "} " + super.toString();
    }
}

