package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.entity.reports.Parking;
import com.zagradio.me.zagradio_me_back.repository.ParkingRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.ParkingService;

public class ParkingServiceImpl extends BaseReportService<Parking, ParkingDto> implements ParkingService{

    public ParkingServiceImpl(ParkingRepo reportRepo,ReportMapper<Parking, ParkingDto> reportMapper) {
        super(reportRepo, reportMapper);
    }
    
}
