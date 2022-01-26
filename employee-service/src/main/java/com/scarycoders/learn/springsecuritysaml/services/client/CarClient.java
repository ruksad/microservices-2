package com.scarycoders.learn.springsecuritysaml.services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "/api/v1/cars",name = "carservice")
public interface CarClient {

    @GetMapping(path = "/all")
    String getAllCars();

    @GetMapping(path = "/car/{id}")
    String getById(@PathVariable("id") Long id);

    @GetMapping()
    String getGreeting();
}
