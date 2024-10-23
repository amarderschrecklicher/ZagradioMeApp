package com.zagradio.me.zagradio_me_back.rest.dto.insurance;

import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.enums.InsuranceType;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportDto;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleDto;

public class InsuranceDto extends ReportDto {

    private InsuranceType insuranceType;
    private String provider;
    private String policy;
    private LocalDateTime expiry;
    private VehicleDto vehicle;


    public InsuranceDto() {
        super();
    }

    public InsuranceDto(long id,String description, String location, String status,String media, LocalDateTime timestamp,InsuranceType insuranceType,String provider,String policy,LocalDateTime expiry, VehicleDto vehicle) {
        super(id,description, location, status, media, timestamp);
        this.vehicle = vehicle;
        this.insuranceType = insuranceType;
        this.provider = provider;
        this.policy = policy;
        this.expiry = expiry;
    }

    public InsuranceType getInsuranceType(){
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType){
        this.insuranceType = insuranceType;
    }

    public String getProvider(){
        return provider;
    }

    public void setProvider(String provider){
        this.provider = provider;
    }

    public String getPolicy(){
        return policy;
    }

    public void setPolicy(String policy){
        this.policy = policy;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setTimestamp(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }
}
