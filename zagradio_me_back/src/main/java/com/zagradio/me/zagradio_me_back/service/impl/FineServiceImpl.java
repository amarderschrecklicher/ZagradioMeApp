package com.zagradio.me.zagradio_me_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zagradio.me.zagradio_me_back.entity.Fine;
import com.zagradio.me.zagradio_me_back.repository.FineRepo;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.fine.FineDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.VehicleMapper;
import com.zagradio.me.zagradio_me_back.service.FineService;

public class FineServiceImpl extends BaseReportService<Fine, FineDto> implements FineService{

    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final VehicleMapper vehicleMapper;


    @Autowired
    public FineServiceImpl(FineRepo fineRepo, ReportMapper<Fine, FineDto> fineMapper, VehicleRepo vehicleRepo, VehicleMapper vehicleMapper) {
        super(fineRepo, fineMapper);
        this.vehicleRepo = vehicleRepo;
        this.vehicleMapper = vehicleMapper;
    }

}
