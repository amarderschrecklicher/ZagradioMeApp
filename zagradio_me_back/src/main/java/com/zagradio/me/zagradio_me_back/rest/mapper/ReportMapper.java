package com.zagradio.me.zagradio_me_back.rest.mapper;

import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportInfoDto;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportInfoDto reportToReportInfoDto(Report report);
    
}
