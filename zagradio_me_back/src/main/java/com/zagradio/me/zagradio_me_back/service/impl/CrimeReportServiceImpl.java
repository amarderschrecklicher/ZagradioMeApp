package com.zagradio.me.zagradio_me_back.service.impl;


import com.zagradio.me.zagradio_me_back.entity.reports.CrimeReport;
import com.zagradio.me.zagradio_me_back.repository.CrimeReportRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.CrimeReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.CrimeReportService;

public class CrimeReportServiceImpl extends BaseReportService<CrimeReport, CrimeReportDto> implements CrimeReportService{

    public CrimeReportServiceImpl(CrimeReportRepo reportRepo,ReportMapper<CrimeReport, CrimeReportDto> reportMapper) {
        super(reportRepo, reportMapper);
    }
    
}
