package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.reports.Crime;
import java.util.List;

public interface CrimeRepo extends JpaRepository<Crime,Long>{

    @Query("SELECT r FROM CrimeReport r WHERE r.id = :id")
    Crime findReportById(@Param("id") long id);

    @Query("DELETE FROM CrimeReport r WHERE r.id = :id")
    Crime deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM CrimeReport r WHERE r.user.id = :id")
    List<Crime> getReportsByUserId(@Param("id") long id);

    @Query("SELECT c From CrimeReport c JOIN c.vehicles v WHERE v.id =:vehicleId")
    List<Crime> findCrimeReportsByCrimeType(@Param("vehicleId") Long vehicleId);
    
}
