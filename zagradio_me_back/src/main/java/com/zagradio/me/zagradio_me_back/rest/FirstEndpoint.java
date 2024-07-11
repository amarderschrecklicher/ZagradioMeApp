package com.zagradio.me.zagradio_me_back.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path = "test")
public class FirstEndpoint {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping
    public ResponseEntity<String> firstEndpointMethod() {
        log.trace("got a request");
        return new ResponseEntity<>("Arslan was here", HttpStatus.OK);
    }
}
