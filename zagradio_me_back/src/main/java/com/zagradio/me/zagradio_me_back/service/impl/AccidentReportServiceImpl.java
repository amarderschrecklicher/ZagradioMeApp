package com.zagradio.me.zagradio_me_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Collectors;

import com.zagradio.me.zagradio_me_back.entity.reports.AccidentReport;
import com.zagradio.me.zagradio_me_back.repository.AccidentReportRepo;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.AccidentReportMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.VehicleMapper;
import com.zagradio.me.zagradio_me_back.service.AccidentReportService;


public class AccidentReportServiceImpl extends BaseReportService<AccidentReport, AccidentReportDto> implements AccidentReportService {


    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final VehicleMapper vehicleMapper;


    @Autowired
    public AccidentReportServiceImpl(AccidentReportRepo reportRepo, ReportMapper<AccidentReport, AccidentReportDto> reportMapper, VehicleRepo vehicleRepo, VehicleMapper vehicleMapper) {
        super(reportRepo, reportMapper);
        this.vehicleRepo = vehicleRepo;
        this.vehicleMapper = vehicleMapper;
    }

    
}
