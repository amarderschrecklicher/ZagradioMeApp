package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;
import java.util.List;

public interface AccidentReportService {

    public AccidentReportDto getReportInfo(Long id);

    AccidentReportDto createReport(ParkingReportDto reportCreateDto);

    AccidentReportDto updateReport(Long id, AccidentReportDto reportCreateDto);

    List<AccidentReportDto> getAllUserReports(Long id);

    void deleteReport(Long id);
    
}