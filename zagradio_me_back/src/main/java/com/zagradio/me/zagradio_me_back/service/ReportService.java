package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportInfoDto;

public interface ReportService {


    public ReportInfoDto getReportInfo(Long id);

    ReportInfoDto createReport(ReportCreateDto reportCreateDto);
    
}