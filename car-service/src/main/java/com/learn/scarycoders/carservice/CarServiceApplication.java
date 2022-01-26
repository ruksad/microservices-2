package com.learn.scarycoders.carservice;

import java.util.stream.Stream;
import com.learn.scarycoders.carservice.model.Car;
import com.learn.scarycoders.carservice.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableDiscoveryClient
@SpringBootApplication
public class CarServiceApplication {

    @Autowired
    Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository carRepository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
                carRepository.save(new Car(name));
            });
            carRepository.findAll().forEach(System.out::println);
        };
    }
}

