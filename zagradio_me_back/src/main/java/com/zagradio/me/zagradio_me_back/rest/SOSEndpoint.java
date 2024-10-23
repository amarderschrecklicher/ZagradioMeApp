package com.zagradio.me.zagradio_me_back.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.report.SOSDto;
import com.zagradio.me.zagradio_me_back.service.ReportService;
import com.zagradio.me.zagradio_me_back.service.SOSService;

@RestController
@RequestMapping(path = "/sos")
public class SOSEndpoint extends BaseReportEndpoint<SOSService, SOSDto> {

    private final SOSService sosService;

    public SOSEndpoint(SOSService sosService) {
        super(sosService);
        this.sosService = sosService;
    }

    @Override
    protected ReportService<SOSDto> getReportService() {
        return sosService;
    }

    @Override
    protected String getEndpointName() {
        return "sos";
    }
}