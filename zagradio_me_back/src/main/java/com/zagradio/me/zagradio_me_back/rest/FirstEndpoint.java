package com.zagradio.me.zagradio_me_back.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class FirstEndpoint {

    @GetMapping
    public ResponseEntity<String> firstEndpointMethod() {
        return new ResponseEntity<>("Arslan was here", HttpStatus.OK);
    }
}
