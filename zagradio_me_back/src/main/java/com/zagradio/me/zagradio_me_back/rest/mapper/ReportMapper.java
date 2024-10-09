package com.zagradio.me.zagradio_me_back.rest.mapper;

import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.entity.reports.ParkingReport;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ParkingReportInfoDto;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ParkingReportInfoDto parkingReportToParkingReportInfoDto(ParkingReport report);
    
}
