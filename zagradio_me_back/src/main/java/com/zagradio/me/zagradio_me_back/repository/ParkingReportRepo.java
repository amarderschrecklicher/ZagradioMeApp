package com.zagradio.me.zagradio_me_back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.reports.ParkingReport;

public interface ParkingReportRepo extends JpaRepository<ParkingReport,Long> {

    @Query("SELECT p From ParkingReport p JOIN p.vehicles v WHERE v.id =:vehicleId")
    List<ParkingReport> findParkingReportsByVehicleId(@Param("vehicleId") Long vehicleId);
    
}
