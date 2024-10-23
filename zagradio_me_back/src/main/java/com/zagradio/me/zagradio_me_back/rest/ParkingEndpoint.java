package com.zagradio.me.zagradio_me_back.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingDto;
import com.zagradio.me.zagradio_me_back.service.ParkingService;
import com.zagradio.me.zagradio_me_back.service.ReportService;

@RestController
@RequestMapping(path = "/parking")
public class ParkingEndpoint extends BaseReportEndpoint<ParkingService, ParkingDto> {

    private final ParkingService parkingService;

    public ParkingEndpoint(ParkingService parkingService) {
        super(parkingService);
        this.parkingService = parkingService;
    }

    @Override
    protected ReportService<ParkingDto> getReportService() {
        return parkingService;
    }

    @Override
    protected String getEndpointName() {
        return "parking";
    }
}