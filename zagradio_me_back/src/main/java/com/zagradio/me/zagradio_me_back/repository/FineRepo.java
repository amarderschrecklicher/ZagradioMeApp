package com.zagradio.me.zagradio_me_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zagradio.me.zagradio_me_back.entity.Fine;

public interface FineRepo extends JpaRepository<Fine,Long>{

    @Query("SELECT f FROM Fine f WHERE f.id = :id")
    Fine findFineById(@Param("id") long id);

    @Query("DELETE FROM Fine f WHERE f.id = :id")
    Fine deleteFineById(@Param("id") long id);

    @Query("SELECT f FROM Fine f WHERE f.user.id = :id")
    List<Fine> getFinesByUserId(@Param("id") long id);
}