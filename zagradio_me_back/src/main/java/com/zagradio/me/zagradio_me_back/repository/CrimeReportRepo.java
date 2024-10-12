package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.reports.CrimeReport;
import java.util.List;

public interface CrimeReportRepo extends JpaRepository<CrimeReport,Long>{

    @Query("SELECT r FROM CrimeReport r WHERE r.id = :id")
    CrimeReport findReportById(@Param("id") long id);

    @Query("DELETE FROM CrimeReport r WHERE r.id = :id")
    CrimeReport deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM CrimeReport r WHERE r.user.id = :id")
    List<CrimeReport> getReportsByUserId(@Param("id") long id);

    @Query("SELECT c From CrimeReport c JOIN c.vehicles v WHERE v.id =:vehicleId")
    List<CrimeReport> findCrimeReportsByCrimeType(@Param("vehicleId") Long vehicleId);
    
}
