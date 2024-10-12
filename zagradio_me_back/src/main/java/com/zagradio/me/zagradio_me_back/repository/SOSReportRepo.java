package com.zagradio.me.zagradio_me_back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.reports.SOSReport;

public interface SOSReportRepo extends JpaRepository<SOSReport,Long> {

    @Query("SELECT r FROM SOSReport r WHERE r.id = :id")
    SOSReport findReportById(@Param("id") long id);

    @Query("DELETE FROM SOSReport r WHERE r.id = :id")
    SOSReport deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM SOSReport r WHERE r.user.id = :id")
    List<SOSReport> getReportsByUserId(@Param("id") long id);

    @Query("SELECT s From AccidentReport s JOIN s.vehicles v WHERE v.id =:vehicleId")
    List<SOSReport> findSOSReportsByEmergencyType(@Param("vehicleId") Long vehicleId);
    
}
