package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.entity.reports.ParkingReport;
import com.zagradio.me.zagradio_me_back.repository.ParkingReportRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.ParkingReportService;

public class ParkingReportServiceImpl extends BaseReportService<ParkingReport, ParkingReportDto> implements ParkingReportService{

    public ParkingReportServiceImpl(ParkingReportRepo reportRepo,ReportMapper<ParkingReport, ParkingReportDto> reportMapper) {
        super(reportRepo, reportMapper);
    }
    
}
