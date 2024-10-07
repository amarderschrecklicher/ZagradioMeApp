package com.zagradio.me.zagradio_me_back.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.vehicle.VehicleInfoDto;
import com.zagradio.me.zagradio_me_back.service.VehicleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path = "/vehicle")
public class VehicleEndpoint {

    private final VehicleService vehicleService;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public VehicleEndpoint(VehicleService carPlateService) {
        this.vehicleService = carPlateService;
    }

    @GetMapping("info/{id}")
        public VehicleInfoDto getReportInfo(@PathVariable("id") long id) {
        log.info("GET carplate/info/{}", id);
        return vehicleService.getVehicleInfo(id);
    }

    @PostMapping("create")
    public VehicleInfoDto createReportInfo(@Valid @RequestBody VehicleCreateDto carPlateCreateDto) {
        log.info("POST carplate/create/{}", carPlateCreateDto);
        return vehicleService.createVehicle(carPlateCreateDto);
    }

    @PostMapping("update/{id}")
    public VehicleInfoDto updateReportInfo(@PathVariable("id") long id, @Valid @RequestBody VehicleCreateDto carPlateCreateDto) {
        log.info("UPDATE carplate/update/{}", carPlateCreateDto);
        return vehicleService.updateVehicle(id, carPlateCreateDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteReport(@PathVariable("id") long id, @Valid @RequestBody VehicleCreateDto carPlateCreateDto) {
        log.info("DELETE carplate/delete/{}", carPlateCreateDto);
        vehicleService.deleteVehicle(id);
    }
    
}
