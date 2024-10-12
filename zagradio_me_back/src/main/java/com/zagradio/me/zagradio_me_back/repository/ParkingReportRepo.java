package com.zagradio.me.zagradio_me_back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.reports.ParkingReport;

public interface ParkingReportRepo extends JpaRepository<ParkingReport,Long> {

    @Query("SELECT r FROM ParkingReport r WHERE r.id = :id")
    ParkingReport findReportById(@Param("id") long id);

    @Query("DELETE FROM ParkingReport r WHERE r.id = :id")
    ParkingReport deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM ParkingReport r WHERE r.user.id = :id")
    List<ParkingReport> getReportsByUserId(@Param("id") long id);

    @Query("SELECT p From ParkingReport p JOIN p.vehicles v WHERE v.id =:vehicleId")
    List<ParkingReport> findParkingReportsByVehicleId(@Param("vehicleId") Long vehicleId);
    
}
