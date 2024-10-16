package com.zagradio.me.zagradio_me_back.entity.reports;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.enums.EmergencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SOSReport extends Report {

    @Column
    private EmergencyType emergencyType;
}
