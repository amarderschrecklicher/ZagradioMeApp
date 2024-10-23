package com.zagradio.me.zagradio_me_back.rest.mapper;

import org.mapstruct.Mapper;

import com.zagradio.me.zagradio_me_back.entity.Fine;
import com.zagradio.me.zagradio_me_back.rest.dto.fine.FineDto;

@Mapper(componentModel = "spring")
public interface FineMapper {

    public FineDto fineToFineDto(Fine fine);
    
}
