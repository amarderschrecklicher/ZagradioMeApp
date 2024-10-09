package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportInfoDto;
import java.util.List;

public interface ReportService {

    public ParkingReportInfoDto getReportInfo(Long id);

    ParkingReportInfoDto createReport(ParkingReportCreateDto reportCreateDto);

    ParkingReportInfoDto updateReport(Long id,ParkingReportCreateDto reportCreateDto);

    List<ParkingReportInfoDto> getAllUserReports(Long id);

    void deleteReport(Long id);
    
}