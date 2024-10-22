package com.zagradio.me.zagradio_me_back.entity;
import com.zagradio.me.zagradio_me_back.enums.FineType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;



@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fine extends Report {

    @Column(nullable = false)
    private FineType crime;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    
}
