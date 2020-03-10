package com.learn.scarycoders.carservice.repo;

import com.learn.scarycoders.carservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car,Long> {

}
