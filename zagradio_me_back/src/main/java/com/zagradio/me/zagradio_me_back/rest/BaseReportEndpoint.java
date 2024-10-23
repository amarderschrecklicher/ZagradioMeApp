package com.zagradio.me.zagradio_me_back.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportDto;
import com.zagradio.me.zagradio_me_back.service.ReportService;

import jakarta.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

public abstract class BaseReportEndpoint<S , D extends ReportDto> {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    protected final S service;

    public BaseReportEndpoint(S service) {
        this.service = service;
    }

    @GetMapping("info/{id}")
    public D getReportInfo(@PathVariable("id") long id) {
        log.info("GET {}/info/{}", getEndpointName(), id);
        return getReportService().getReportInfo(id);
    }

    @GetMapping("info/all/{id}")
    public List<D> getAllReportsInfo(@PathVariable("id") long id) {
        log.info("GET {}/info/all/{}", getEndpointName(), id);
        return getReportService().getAllReports(id);
    }

    @PostMapping("create")
    public D createReportInfo(@Valid @RequestBody D reportCreateDto) {
        log.info("POST {}/create/{}", getEndpointName(), reportCreateDto);
        return getReportService().createReport(reportCreateDto);
    }

    @PostMapping("update/{id}")
    public D updateReportInfo(@PathVariable("id") long id, @Valid @RequestBody D reportCreateDto) {
        log.info("UPDATE {}/update/{}", getEndpointName(), reportCreateDto);
        return getReportService().updateReport(id, reportCreateDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteReport(@PathVariable("id") long id) {
        log.info("DELETE {}/delete/{}", getEndpointName(), id);
        getReportService().deleteReport(id);
    }

    // This method returns the specific service implementation (like FineService, AccidentService)
    protected abstract ReportService<D> getReportService();

    // This method returns the endpoint name for logging (like "fine", "accident")
    protected abstract String getEndpointName();
}
