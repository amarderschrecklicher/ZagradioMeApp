package com.zagradio.me.zagradio_me_back.rest.mapper;

import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.entity.reports.Accident;
import com.zagradio.me.zagradio_me_back.rest.dto.report.AccidentDto;

@Mapper(componentModel = "spring")
public interface AccidentMapper {

    AccidentDto reportToReportDto(Accident report);
    
}
