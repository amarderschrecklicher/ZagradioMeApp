package com.zagradio.me.zagradio_me_back.service.impl;


import com.zagradio.me.zagradio_me_back.entity.reports.Crime;
import com.zagradio.me.zagradio_me_back.repository.CrimeRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.report.CrimeDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.CrimeService;

public class CrimeServiceImpl extends BaseReportService<Crime, CrimeDto> implements CrimeService{

    public CrimeServiceImpl(CrimeRepo reportRepo,ReportMapper<Crime, CrimeDto> reportMapper) {
        super(reportRepo, reportMapper);
    }
    
}
