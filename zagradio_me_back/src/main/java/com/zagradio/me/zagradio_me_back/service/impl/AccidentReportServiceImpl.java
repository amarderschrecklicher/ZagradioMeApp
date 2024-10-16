package com.zagradio.me.zagradio_me_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

import com.zagradio.me.zagradio_me_back.entity.reports.AccidentReport;
import com.zagradio.me.zagradio_me_back.repository.AccidentReportRepo;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.AccidentReportMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.VehicleMapper;
import com.zagradio.me.zagradio_me_back.service.AccidentReportService;


public class AccidentReportServiceImpl implements AccidentReportService {

    @Autowired
    private final AccidentReportRepo reportRepo;
    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final AccidentReportMapper reportMapper;
    @Autowired
    private final VehicleMapper vehicleMapper;


    public AccidentReportServiceImpl(AccidentReportRepo reportRepo, VehicleRepo vehicleRepo,AccidentReportMapper reportMapper, VehicleMapper vehicleMapper) {
        this.reportRepo= reportRepo;
        this.vehicleRepo = vehicleRepo;
        this.reportMapper = reportMapper;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public AccidentReportDto getReportInfo(Long id) {
        return reportMapper.reportToReportDto(reportRepo.findReportById(id));
    }

    @Override
    public AccidentReportDto createReport(AccidentReportDto reportCreateDto) {


        AccidentReport newReport = AccidentReport.builder()
        .vehicles(vehicleMapper.vehicleSetToVehicleDtoSet(reportCreateDto.vehicles()))
        .description(reportCreateDto.description())
        .media(reportCreateDto.media())
        .location(reportCreateDto.location())
        .status(reportCreateDto.status())
        .timestamp(reportCreateDto.timestamp())
        .build();

        newReport = reportRepo.save(newReport);

        return reportMapper.reportToReportDto(newReport);

    }

    @Override
    public AccidentReportDto updateReport(Long id,AccidentReportDto reportCreateDto) {


        AccidentReport existingReport = reportRepo.findReportById(id);

        existingReport.setDescription(reportCreateDto.description());
        existingReport.setTimestamp(reportCreateDto.timestamp());
        existingReport.setLocation(reportCreateDto.location());
        existingReport.setVehicles(vehicleMapper.vehicleSetToVehicleDtoSet(reportCreateDto.vehicles()));
        existingReport.setStatus(reportCreateDto.status());


        AccidentReport updatedReport = reportRepo.save(existingReport);

        return reportMapper.reportToReportDto(updatedReport);
    }


    @Override
    public void deleteReport(Long id) {
        reportRepo.deleteReportById(id);
    }

    @Override
    public List<AccidentReportDto> getAllReports(Long id) {

        List<AccidentReport> allReports = reportRepo.getReportsByUserId(id);

        return allReports.stream()
            .map(reportMapper::reportToReportDto)
            .collect(Collectors.toList());

    }

    
}
