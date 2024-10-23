package com.zagradio.me.zagradio_me_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Collectors;

import com.zagradio.me.zagradio_me_back.entity.reports.Accident;
import com.zagradio.me.zagradio_me_back.repository.AccidentRepo;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.AccidentMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.VehicleMapper;
import com.zagradio.me.zagradio_me_back.service.AccidentService;


public class AccidentServiceImpl extends BaseReportService<Accident, AccidentDto> implements AccidentService {


    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final VehicleMapper vehicleMapper;


    @Autowired
    public AccidentServiceImpl(AccidentRepo reportRepo, ReportMapper<Accident, AccidentDto> reportMapper, VehicleRepo vehicleRepo, VehicleMapper vehicleMapper) {
        super(reportRepo, reportMapper);
        this.vehicleRepo = vehicleRepo;
        this.vehicleMapper = vehicleMapper;
    }

    
}
