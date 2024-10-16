package com.zagradio.me.zagradio_me_back.service;

import java.util.List;

import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportDto;

public abstract interface ReportService<T extends ReportDto> {

    public T getReportInfo(Long id);

    T createReport(T reportDto);

    T updateReport(Long id, T reportDto);

    List<T> getAllReports(Long id);

    void deleteReport(Long id);

}
