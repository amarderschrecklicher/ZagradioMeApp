package com.zagradio.me.zagradio_me_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.Insurance;

public interface InsuranceRepo extends JpaRepository<Insurance,Long>{


    @Query("SELECT i FROM Insurance i WHERE i.id = :id")
    Insurance findInsuranceById(@Param("id") long id);

    @Query("DELETE FROM Insurance i WHERE i.id = :id")
    Insurance deleteInsuranceById(@Param("id") long id);

    @Query("SELECT i FROM Insurance i WHERE i.user.id = :id")
    List<Insurance> getInsurancesByUserId(@Param("id") long id);
    
}
