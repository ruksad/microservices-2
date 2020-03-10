package com.learn.scarycoders.apigateway.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("car-service")
@Component
public interface CarClient {

    @GetMapping("/cars")
    @CrossOrigin
    String readCars();
}
