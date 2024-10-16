package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;
import java.util.List;

public interface AccidentReportService {

    public AccidentReportDto getReportInfo(Long id);

    AccidentReportDto createReport(AccidentReportDto reportCreateDto);

    AccidentReportDto updateReport(Long id, AccidentReportDto reportCreateDto);

    List<AccidentReportDto> getAllReports(Long id);

    void deleteReport(Long id);
    
}