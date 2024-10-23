package com.zagradio.me.zagradio_me_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.zagradio.me.zagradio_me_back.entity.reports.Accident;

public interface AccidentRepo extends JpaRepository<Accident,Long> {

    @Query("SELECT r FROM AccidentReport r WHERE r.id = :id")
    Accident findReportById(@Param("id") long id);

    @Query("DELETE FROM AccidentReport r WHERE r.id = :id")
    Accident deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM AccidentReport r WHERE r.user.id = :id")
    List<Accident> getReportsByUserId(@Param("id") long id);

    @Query("SELECT a From AccidentReport a JOIN a.vehicles v WHERE v.id =:vehicleId")
    List<Accident> findAccidentReportsByVehicleId(@Param("vehicleId") Long vehicleId);
    
}
