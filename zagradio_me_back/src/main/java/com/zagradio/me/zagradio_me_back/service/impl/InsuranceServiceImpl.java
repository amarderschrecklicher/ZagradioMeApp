package com.zagradio.me.zagradio_me_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.zagradio.me.zagradio_me_back.entity.Insurance;
import com.zagradio.me.zagradio_me_back.repository.InsuranceRepo;
import com.zagradio.me.zagradio_me_back.repository.VehicleRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.insurance.InsuranceDto;
import com.zagradio.me.zagradio_me_back.rest.mapper.ReportMapper;
import com.zagradio.me.zagradio_me_back.rest.mapper.VehicleMapper;
import com.zagradio.me.zagradio_me_back.service.InsuranceService;

public class InsuranceServiceImpl extends BaseReportService<Insurance, InsuranceDto> implements InsuranceService {


    @Autowired
    private final VehicleRepo vehicleRepo;
    @Autowired
    private final VehicleMapper vehicleMapper;


    @Autowired
    public InsuranceServiceImpl(InsuranceRepo insuranceRepo, ReportMapper<Insurance, InsuranceDto> insuranceMapper, VehicleRepo vehicleRepo, VehicleMapper vehicleMapper) {
        super(insuranceRepo, insuranceMapper);
        this.vehicleRepo = vehicleRepo;
        this.vehicleMapper = vehicleMapper;
    }
    
}
