package com.zagradio.me.zagradio_me_back.entity;

import java.util.Set;

import com.zagradio.me.zagradio_me_back.entity.reports.AccidentReport;
import com.zagradio.me.zagradio_me_back.entity.reports.ParkingReport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id", referencedColumnName = "id")
    private Insurance insurance;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fine> fines = new ArrayList<>();

    @ManyToMany(mappedBy = "vehicles")
    private Set<AccidentReport> accidentReports = new HashSet<>(); // A set of reports (accident or parking) involving this vehicle

    @ManyToMany(mappedBy = "vehicles")
    private Set<ParkingReport> parkingReports = new HashSet<>();

    
}
