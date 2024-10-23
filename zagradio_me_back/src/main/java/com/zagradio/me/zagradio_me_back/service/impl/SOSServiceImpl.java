package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.entity.reports.SOS;
import com.zagradio.me.zagradio_me_back.repository.SOSRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.SOSDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.SOSService;

public class SOSServiceImpl extends BaseReportService<SOS, SOSDto> implements SOSService{

    public SOSServiceImpl(SOSRepo reportRepo,ReportMapper<SOS, SOSDto> reportMapper) {
        super(reportRepo, reportMapper);
    }
    
}
