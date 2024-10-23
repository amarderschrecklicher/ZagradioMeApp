package com.zagradio.me.zagradio_me_back.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentDto;
import com.zagradio.me.zagradio_me_back.service.AccidentService;
import com.zagradio.me.zagradio_me_back.service.ReportService;



@RestController
@RequestMapping(path = "/accident")
public class AccidentEndpoint extends BaseReportEndpoint<AccidentService, AccidentDto> {

    private final AccidentService accidentService;

    public AccidentEndpoint(AccidentService accidentService) {
        super(accidentService);
        this.accidentService = accidentService;
    }

    @Override
    protected ReportService<AccidentDto> getReportService() {
        return accidentService;
    }

    @Override
    protected String getEndpointName() {
        return "accident";
    }
}
