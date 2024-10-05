package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.zagradio.me.zagradio_me_back.entity.Report;

public interface ReportRepo extends JpaRepository<Report, Integer>  {

    @Query("SELECT r FROM Report r WHERE r.id = :id")
    Report findReportById(@Param("id") long id);

    @Query("DELETE FROM Report r WHERE r.id = :id")
    Report deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM Report r WHERE r.user.id = :id")
    List<Report> getReportsByUserId(@Param("id") long id);
    
}
