package com.zagradio.me.zagradio_me_back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.reports.Parking;

public interface ParkingRepo extends JpaRepository<Parking,Long> {

    @Query("SELECT r FROM ParkingReport r WHERE r.id = :id")
    Parking findReportById(@Param("id") long id);

    @Query("DELETE FROM ParkingReport r WHERE r.id = :id")
    Parking deleteReportById(@Param("id") long id);

    @Query("SELECT r FROM ParkingReport r WHERE r.user.id = :id")
    List<Parking> getReportsByUserId(@Param("id") long id);

    @Query("SELECT p From ParkingReport p JOIN p.vehicles v WHERE v.id =:vehicleId")
    List<Parking> findParkingReportsByVehicleId(@Param("vehicleId") Long vehicleId);
    
}
