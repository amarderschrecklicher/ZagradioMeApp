package com.zagradio.me.zagradio_me_back.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.insurance.InsuranceDto;
import com.zagradio.me.zagradio_me_back.service.InsuranceService;
import com.zagradio.me.zagradio_me_back.service.ReportService;

@RestController
@RequestMapping(path = "/insurance")
public class InsuranceEndpoint extends BaseReportEndpoint<InsuranceService, InsuranceDto> {

    private final InsuranceService insuranceService;

    public InsuranceEndpoint(InsuranceService insuranceService) {
        super(insuranceService);
        this.insuranceService = insuranceService;
    }

    @Override
    protected ReportService<InsuranceDto> getReportService() {
        return insuranceService;
    }

    @Override
    protected String getEndpointName() {
        return "insurance";
    }
}