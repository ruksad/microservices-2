package com.learn.scarycoders.carservice.Controller;

import com.learn.scarycoders.carservice.model.Car;
import com.learn.scarycoders.carservice.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cars")
public class CarsController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> all = carRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping(value = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getById(@PathVariable("id") Long carId){
        Optional<Car> byId = carRepository.findById(carId);
        return byId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(new Car()));
    }

    @GetMapping()
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Hello from cars service= "+environment.getProperty("local.server.port"));
    }
}
