package com.zagradio.me.zagradio_me_back.rest.mapper;

import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.entity.reports.AccidentReport;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentReportDto;

@Mapper(componentModel = "spring")
public interface AccidentReportMapper {

    AccidentReportDto reportToReportDto(AccidentReport report);
    
}
