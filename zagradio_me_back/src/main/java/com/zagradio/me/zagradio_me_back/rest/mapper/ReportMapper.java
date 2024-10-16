package com.zagradio.me.zagradio_me_back.rest.mapper;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportDto;

public interface ReportMapper<T extends Report, D extends ReportDto> {

    D reportToReportDto(T report);

    T dtoToReport(D reportDto);

    void updateReportFromDto(D dto, T report);
}

