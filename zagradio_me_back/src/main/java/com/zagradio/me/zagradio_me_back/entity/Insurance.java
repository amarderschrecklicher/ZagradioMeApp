package com.zagradio.me.zagradio_me_back.entity;
import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.enums.InsuranceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;



@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance extends Report {

    @Column(nullable = false)
    private InsuranceType crime;

    @Column(name = "policy", nullable = false)
    private String policy;

    @Column(nullable = false)
    private LocalDateTime expiry;
    
}
