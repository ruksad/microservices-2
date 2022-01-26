package com.scarycoders.learn.springsecuritysaml.controller;

import com.scarycoders.learn.springsecuritysaml.model.Employee;
import com.scarycoders.learn.springsecuritysaml.services.EmployeeService;
import com.scarycoders.learn.springsecuritysaml.services.client.CarClient;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    private Environment env;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarClient carClient;

    @Value("${api-gateway.deployed}")
    private String apiGateWay;
    @Autowired
    private EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping()
    public ResponseEntity<String> sayHi(){

        return ResponseEntity.ok().body("Hello employee service on port= "+env.getProperty("local.server.port"));
    }
    @GetMapping(value= "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam("pageNo") int pageNumber
            ,@RequestParam("pageSize") int pageSize){
        PageRequest page = PageRequest.of(pageNumber, pageSize);
        List<Employee> all = employeeService.findAll(page);
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getById(@PathVariable("id") Integer id){
        Employee byId = employeeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @GetMapping(path = "/employee/rest-template/cars",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCars(){
        log.info("Inside get cas by rest template");
        String forObject = restTemplate.getForObject(apiGateWay+"/api/v1/cars/all", String.class);

        return ResponseEntity.ok(forObject);
    }

    @GetMapping(path = "/employee/feign/cars",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCarsByFeinClient(){
        log.info("Inside get cars by open fein client");
        return ResponseEntity.ok(carClient.getAllCars());
    }

}
