package com.zagradio.me.zagradio_me_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.entity.reports.AccidentReport;
import com.zagradio.me.zagradio_me_back.repository.AccidentReportRepo;
import com.zagradio.me.zagradio_me_back.repository.ReportRepo;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.AccidentReportMapper;
import com.zagradio.me.zagradio_me_back.service.AccidentReportService;

import jakarta.persistence.EntityNotFoundException;

public class AccidentReportServiceImpl implements AccidentReportService{

    @Autowired
    private final AccidentReportRepo reportRepo;
    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final AccidentReportMapper reportMapper;


    public AccidentReportServiceImpl(AccidentReportRepo reportRepo, VehicleRepo vehicleRepo,AccidentReportMapper reportMapper) {
        this.reportRepo= reportRepo;
        this.vehicleRepo = vehicleRepo;
        this.reportMapper = reportMapper;
    }

    @Override
    public AccidentReportDto getReportInfo(Long id) {
        return reportMapper.accidentReportToAccidentReportDto(reportRepo.findReportById(id));
    }

    @Override
    public AccidentReportDto createReport(ParkingReportDto reportCreateDto) {


        AccidentReport newReport = AccidentReport.builder()
        .vehicles(reportCreateDto.vehicles())
        .description(reportCreateDto.description())
        .photo(reportCreateDto.photo())
        .location(reportCreateDto.location())
        .status(reportCreateDto.status())
        .dateOfReport(reportCreateDto.dateOfReport())
        .build();

        newReport = reportRepo.save(newReport);

        return reportMapper.accidentReportToAccidentReportDto(newReport);

    }

    @Override
    public AccidentReportDto updateReport(Long id,AccidentReportDto reportCreateDto) {


        AccidentReport existingReport = reportRepo.findReportById(id);

        existingReport.setDescription(reportCreateDto.description());
        existingReport.setReportDate(reportCreateDto.reportDate());
        existingReport.setLocation(reportCreateDto.location());
        existingReport.setVehicle(reportCreateDto.vehicle());
        existingReport.setStatus(reportCreateDto.status());


        Report updatedReport = reportRepo.save(existingReport);

        return reportMapper.accidentReportToAccidentReportDto(updatedReport);
    }


    @Override
    public void deleteReport(Long id) {
        reportRepo.deleteReportById(id);
    }

    @Override
    public List<AccidentReportDto> getAllUserReports(Long id) {

        List<AccidentReport> allReports = reportRepo.getReportsByUserId(id);

        return allReports.stream()
            .map(reportMapper::accidentReportToAccidentReportDto)
            .collect(Collectors.toList());

    }

    
}
