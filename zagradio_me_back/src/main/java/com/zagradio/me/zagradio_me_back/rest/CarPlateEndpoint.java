package com.zagradio.me.zagradio_me_back.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.car_plate.CarPlateInfoDto;
import com.zagradio.me.zagradio_me_back.service.CarPlateService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path = "/carplate")
public class CarPlateEndpoint {

    private final CarPlateService carPlateService;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public CarPlateEndpoint(CarPlateService carPlateService) {
        this.carPlateService = carPlateService;
    }

    @GetMapping("info/{id}")
        public CarPlateInfoDto getReportInfo(@PathVariable("id") long id) {
        log.info("GET user/info/{}", id);
        return carPlateService.getCarPlateInfo(id);
    }

    @PostMapping("create")
    public CarPlateInfoDto createReportInfo(@Valid @RequestBody CarPlateCreateDto carPlateCreateDto) {
        log.info("POST report/create/{}", carPlateCreateDto);
        return carPlateService.createCarPlate(carPlateCreateDto);
    }

    @PostMapping("update/{id}")
    public CarPlateInfoDto updateReportInfo(@PathVariable("id") long id, @Valid @RequestBody CarPlateCreateDto carPlateCreateDto) {
        log.info("UPDATE report/update/{}", carPlateCreateDto);
        return carPlateService.updateCarPlate(id, carPlateCreateDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteReport(@PathVariable("id") long id, @Valid @RequestBody CarPlateCreateDto carPlateCreateDto) {
        log.info("DELETE report/delete/{}", carPlateCreateDto);
        carPlateService.deleteCarPlate(id);
    }
    
}
