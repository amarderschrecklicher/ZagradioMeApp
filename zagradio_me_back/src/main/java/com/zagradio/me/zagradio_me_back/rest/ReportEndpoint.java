package com.zagradio.me.zagradio_me_back.rest;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportInfoDto;
import com.zagradio.me.zagradio_me_back.service.ReportService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path = "/report")
public class ReportEndpoint {
    
    private final ReportService reportService;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ReportEndpoint(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("info/{id}")
        public ReportInfoDto getReportInfo(@PathVariable("id") long id) {
        log.info("GET user/info/{}", id);
        return reportService.getReportInfo(id);
    }

    @PostMapping("create")
    public ReportInfoDto createReportInfo(@Valid @RequestBody ReportCreateDto reportCreateDto) {
        log.info("POST report/create/{}", reportCreateDto);
        return reportService.createReport(reportCreateDto);
    }

    @PostMapping("update/{id}")
    public ReportInfoDto updateReportInfo(@PathVariable("id") long id, @Valid @RequestBody ReportCreateDto reportCreateDto) {
        log.info("UPDATE report/update/{}", reportCreateDto);
        return reportService.updateReport(id, reportCreateDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteReport(@PathVariable("id") long id, @Valid @RequestBody ReportCreateDto reportCreateDto) {
        log.info("DELETE report/delete/{}", reportCreateDto);
        reportService.deleteReport(id);
    }
}
