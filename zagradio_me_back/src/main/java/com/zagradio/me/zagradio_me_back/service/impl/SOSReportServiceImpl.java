package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.entity.reports.SOSReport;
import com.zagradio.me.zagradio_me_back.repository.SOSReportRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.SOSReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.SOSReportService;

public class SOSReportServiceImpl extends BaseReportService<SOSReport, SOSReportDto> implements SOSReportService{

    public SOSReportServiceImpl(SOSReportRepo reportRepo,ReportMapper<SOSReport, SOSReportDto> reportMapper) {
        super(reportRepo, reportMapper);
    }
    
}
