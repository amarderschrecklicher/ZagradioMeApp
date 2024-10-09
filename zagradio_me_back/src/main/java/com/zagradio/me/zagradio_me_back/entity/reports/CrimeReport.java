package com.zagradio.me.zagradio_me_back.entity.reports;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.enums.CrimeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CrimeReport extends Report {

    @Column(nullable = false)
    private CrimeType crime;


}
