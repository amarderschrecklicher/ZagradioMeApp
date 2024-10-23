package com.zagradio.me.zagradio_me_back.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.report.CrimeDto;
import com.zagradio.me.zagradio_me_back.service.CrimeService;
import com.zagradio.me.zagradio_me_back.service.ReportService;

@RestController
@RequestMapping(path = "/crime")
public class CrimeEndpoint extends BaseReportEndpoint<CrimeService, CrimeDto> {

    private final CrimeService crimeService;

    public CrimeEndpoint(CrimeService crimeService) {
        super(crimeService);
        this.crimeService = crimeService;
    }

    @Override
    protected ReportService<CrimeDto> getReportService() {
        return crimeService;
    }

    @Override
    protected String getEndpointName() {
        return "crime";
    }
}

