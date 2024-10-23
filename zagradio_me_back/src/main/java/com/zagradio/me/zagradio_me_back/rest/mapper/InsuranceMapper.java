package com.zagradio.me.zagradio_me_back.rest.mapper;

import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Insurance;
import com.zagradio.me.zagradio_me_back.rest.dto.insurance.InsuranceDto;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    public InsuranceDto insuranceToInsuranceDto(Insurance insurance);
    
}
