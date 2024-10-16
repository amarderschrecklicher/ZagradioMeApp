package com.zagradio.me.zagradio_me_back.entity.reports;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import com.zagradio.me.zagradio_me_back.entity.Report;
import com.zagradio.me.zagradio_me_back.entity.Vehicle;

import java.util.HashSet;


@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AccidentReport extends Report{

    @Column(name = "is_known", nullable = false)
    @Builder.Default
    private Boolean isKnown = true;

    @ManyToMany
    @JoinTable(
        name = "report_vehicle", // Name of the join table
        joinColumns = @JoinColumn(name = "report_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles = new HashSet<>(); // A set of vehicles involved in this report

    
}
