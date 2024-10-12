package com.zagradio.me.zagradio_me_back.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;
import com.zagradio.me.zagradio_me_back.service.AccidentReportService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;



@RestController
@RequestMapping(path = "/accidentreport")
public class AccidentReportEndpoint {

    private final AccidentReportService reportService;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public AccidentReportEndpoint(AccidentReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("info/{id}")
        public AccidentReportDto getReportInfo(@PathVariable("id") long id) {
        log.info("GET report/info/{}", id);
        return reportService.getReportInfo(id);
    }

    @GetMapping("info/all/{id}")
    public List<AccidentReportDto> getAllReportsInfo(@PathVariable("id") long id) {
    log.info("GET report/info/{}", id);
    return reportService.getAllReports(id);
}

    @PostMapping("create")
    public AccidentReportDto createReportInfo(@Valid @RequestBody AccidentReportDto reportCreateDto) {
        log.info("POST report/create/{}", reportCreateDto);
        return reportService.createReport(reportCreateDto);
    }

    @PostMapping("update/{id}")
    public AccidentReportDto updateReportInfo(@PathVariable("id") long id, @Valid @RequestBody AccidentReportDto reportCreateDto) {
        log.info("UPDATE report/update/{}", reportCreateDto);
        return reportService.updateReport(id, reportCreateDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteReport(@PathVariable("id") long id, @Valid @RequestBody AccidentReportDto reportCreateDto) {
        log.info("DELETE report/delete/{}", reportCreateDto);
        reportService.deleteReport(id);
    }
    
}
