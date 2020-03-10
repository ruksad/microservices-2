package com.learn.scarycoders.apigateway.controller;

import java.util.Collection;
import java.util.Collections;
import com.learn.scarycoders.apigateway.model.Car;
import com.learn.scarycoders.apigateway.proxies.CarClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifiedCarsController {

    @Autowired
    private CarClient carClient;

    /*@Autowired
    ModifiedCarsController(CarClient carClient){
        this.carClient=carClient;
    }*/

    private Collection<Car> fallback() {
        return Collections.EMPTY_LIST;
    }

    @GetMapping("/modified-cars")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    private String goodCars() {
        /*final List<Resource> resources = Arrays.asList(carClient.readCars().value());
        return resources.stream().map(x->(Car)x).filter(this::isModified).collect(Collectors.toList());*/
        return carClient.readCars();
    }

    private boolean isModified(Car car) {
        return true;
    }
}
