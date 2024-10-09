package com.zagradio.me.zagradio_me_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.repository.ReportRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportInfoDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.ReportService;

import jakarta.persistence.EntityNotFoundException;

public class ReportServiceImpl implements ReportService{

    @Autowired
    private final ReportRepo reportRepo;
    @Autowired
    private final ReportMapper reportMapper;


    public ReportServiceImpl(ReportRepo reportRepo, ReportMapper reportMapper) {
        this.reportRepo= reportRepo;
        this.reportMapper = reportMapper;
    }

    @Override
    public ParkingReportInfoDto getReportInfo(Long id) {
        return reportMapper.reportToReportInfoDto(reportRepo.findReportById(id));
    }

    @Override
    public ParkingReportInfoDto createReport(ParkingReportCreateDto reportCreateDto) {


        Report newReport = Report.builder()
        .vehicle(reportCreateDto.vehicle())
        .description(reportCreateDto.description())
        .photo(reportCreateDto.photo())
        .location(reportCreateDto.location())
        .build();
        newReport = reportRepo.save(newReport);

        return reportMapper.reportToReportInfoDto(newReport);

    }

    @Override
    public ParkingReportInfoDto updateReport(Long id,ParkingReportCreateDto reportCreateDto) {


        Report existingReport = reportRepo.findReportById(id);

        existingReport.setDescription(reportCreateDto.description());
        existingReport.setReportDate(reportCreateDto.reportDate());
        existingReport.setLocation(reportCreateDto.location());
        existingReport.setVehicle(reportCreateDto.vehicle());
        existingReport.setStatus(reportCreateDto.status());


        Report updatedReport = reportRepo.save(existingReport);

        return reportMapper.reportToReportInfoDto(updatedReport);
    }


    @Override
    public void deleteReport(Long id) {
        reportRepo.deleteReportById(id);
    }

    @Override
    public List<ParkingReportInfoDto> getAllUserReports(Long id) {

        List<Report> allReports = reportRepo.getReportsByUserId(id);

        return allReports.stream()
            .map(reportMapper::reportToReportInfoDto)
            .collect(Collectors.toList());

    }

    
}
