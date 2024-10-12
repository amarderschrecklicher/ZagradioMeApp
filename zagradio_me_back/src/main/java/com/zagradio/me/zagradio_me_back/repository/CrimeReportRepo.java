package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.zagradio.me.zagradio_me_back.entity.reports.CrimeReport;
import java.util.List;

public interface CrimeReportRepo extends JpaRepository<CrimeReport,Long>{

    @Query("SELECT c From CrimeReport c JOIN c.vehicles v WHERE v.id =:vehicleId")
    List<CrimeReport> findCrimeReportsByCrimeType(@Param("vehicleId") Long vehicleId);
    
}
