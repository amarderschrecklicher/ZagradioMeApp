package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zagradio.me.zagradio_me_back.entity.Report;

public interface ReportRepo extends JpaRepository<Report, Integer>  {
    
    
}
