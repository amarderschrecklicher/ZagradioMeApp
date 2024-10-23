package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.zagradio.me.zagradio_me_back.entity.reports.AccidentReport;

public interface AccidentReportRepo extends JpaRepository<AccidentReport,Long> {

    @Query("SELECT r FROM AccidentReport r WHERE r.id = :id")
    AccidentReport findReportById(@Param("id") long id);

    @Query("DELETE FROM AccidentReport r WHERE r.id = :id")
    AccidentReport deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM AccidentReport r WHERE r.user.id = :id")
    List<AccidentReport> getReportsByUserId(@Param("id") long id);

    @Query("SELECT a From AccidentReport a JOIN a.vehicles v WHERE v.id =:vehicleId")
    List<AccidentReport> findAccidentReportsByVehicleId(@Param("vehicleId") Long vehicleId);
    
}