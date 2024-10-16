package com.zagradio.me.zagradio_me_back.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.service.ReportService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


public abstract class BaseReportService<T extends Report, D extends ReportDto> implements ReportService<D> {

    protected final JpaRepository<T, Long> reportRepo;
    protected final ReportMapper<T, D> reportMapper;

    public BaseReportService(JpaRepository<T, Long> reportRepo, ReportMapper<T, D> reportMapper) {
        this.reportRepo = reportRepo;
        this.reportMapper = reportMapper;
    }

    public D getReportInfo(Long id) {
        return reportMapper.reportToReportDto(reportRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Report not found")));
    }

    public D createReport(D reportDto) {
        T newReport = reportMapper.dtoToReport(reportDto);
        newReport = reportRepo.save(newReport);
        return reportMapper.reportToReportDto(newReport);
    }

    public D updateReport(Long id, D reportDto) {
        T existingReport = reportRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Report not found"));
        reportMapper.updateReportFromDto(reportDto, existingReport);
        T updatedReport = reportRepo.save(existingReport);
        return reportMapper.reportToReportDto(updatedReport);
    }

    public void deleteReport(Long id) {
        reportRepo.deleteById(id);
    }

    public List<D> getAllReports(Long userId) {
        return reportRepo.findAll().stream()  // Assuming all reports for the same user
            .map(reportMapper::reportToReportDto)
            .collect(Collectors.toList());
    }
}

