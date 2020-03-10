package com.learn.scarycoders.carservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;

    public Car(String name) {
        this.name = name;
    }
}
