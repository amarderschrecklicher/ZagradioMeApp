package com.zagradio.me.zagradio_me_back.entity;
import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.enums.InsuranceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;



@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance extends Report {

    @Column(nullable = false)
    private InsuranceType insuranceType;

    @Column(nullable = false)
    private String provider;

    @Column(name = "policy", nullable = false)
    private String policy;

    @Column(nullable = false)
    private LocalDateTime expiry;
    
    @OneToOne(mappedBy = "insurance")
    private Vehicle vehicle;
}
