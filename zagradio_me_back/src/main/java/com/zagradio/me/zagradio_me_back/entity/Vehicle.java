package com.zagradio.me.zagradio_me_back.entity;

import java.util.Set;

import com.zagradio.me.zagradio_me_back.entity.reports.ParkingReport;

import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "plate_string", nullable = false)
    private String plateString;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Report> accidentReports = new HashSet<>(); // A set of reports (accident or parking) involving this vehicle

    @ManyToMany(mappedBy = "vehicles")
    private Set<ParkingReport> parkingReports = new HashSet<>();

    
}
