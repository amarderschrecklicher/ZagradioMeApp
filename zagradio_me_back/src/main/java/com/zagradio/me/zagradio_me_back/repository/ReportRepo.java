package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.Report;

public interface ReportRepo extends JpaRepository<Report, Integer>  {

    @Query("SELECT r FROM Report r WHERE r.id = :id")
    Report findReportById(@Param("id") long id);
    
}
