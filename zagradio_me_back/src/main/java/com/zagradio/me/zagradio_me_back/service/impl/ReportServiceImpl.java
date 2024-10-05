package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.repository.ReportRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportInfoDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.ReportService;

public class ReportServiceImpl implements ReportService{


    private final ReportRepo reportRepo;
    private final ReportMapper reportMapper;

    public ReportServiceImpl(ReportRepo reportRepo, ReportMapper reportMapper) {
        this.reportRepo= reportRepo;
        this.reportMapper = reportMapper;
    }

    @Override
    public ReportInfoDto getReportInfo(Long id) {
        return reportMapper.reportToReportInfoDto(reportRepo.findReportById(id));
    }

    @Override
    public ReportInfoDto createReport(ReportCreateDto reportCreateDto) {

        Report newReport = Report.builder()
        .carPlates(reportCreateDto.carPlates())
        .description(reportCreateDto.description())
        .photo(reportCreateDto.photo())
        .location(reportCreateDto.location())
        .build();
        newReport = reportRepo.save(newReport);

        return reportMapper.reportToReportInfoDto(newReport);

    }
    
}
