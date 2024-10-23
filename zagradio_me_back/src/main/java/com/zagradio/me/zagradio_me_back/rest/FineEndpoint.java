package com.zagradio.me.zagradio_me_back.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.fine.FineDto;
import com.zagradio.me.zagradio_me_back.service.FineService;
import com.zagradio.me.zagradio_me_back.service.ReportService;

@RestController
@RequestMapping(path = "/fine")
public class FineEndpoint extends BaseReportEndpoint<FineService, FineDto> {

    private final FineService fineService;

    public FineEndpoint(FineService fineService) {
        super(fineService);
        this.fineService = fineService;
    }

    @Override
    protected ReportService<FineDto> getReportService() {
        return fineService;
    }

    @Override
    protected String getEndpointName() {
        return "fine";
    }
}
