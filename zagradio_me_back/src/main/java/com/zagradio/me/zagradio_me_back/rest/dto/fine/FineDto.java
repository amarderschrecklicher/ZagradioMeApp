package com.zagradio.me.zagradio_me_back.rest.dto.fine;

import java.time.LocalDateTime;

import com.zagradio.me.zagradio_me_back.enums.FineType;
import com.zagradio.me.zagradio_me_back.rest.dto.report.ReportDto;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleDto;

public class FineDto extends ReportDto{

    private FineType fineType;
    private double amount;
    private VehicleDto vehicle;


    public FineDto() {
        super();
    }

    public FineDto(long id,String description, String location, String status,String media, LocalDateTime timestamp,FineType fineType,double amount, VehicleDto vehicle) {
        super(id,description, location, status, media, timestamp);
        this.vehicle = vehicle;
        this.fineType = fineType;
        this.amount = amount;
    }

    public FineType getFineType(){
        return fineType;
    }

    public void setFineType(FineType fineType){
        this.fineType = fineType;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

}
