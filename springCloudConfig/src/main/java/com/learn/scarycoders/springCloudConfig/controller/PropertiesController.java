package com.learn.scarycoders.springCloudConfig.controller;

import com.learn.scarycoders.springCloudConfig.config.Configuration;
import com.learn.scarycoders.springCloudConfig.model.Props;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/properties")
@Slf4j
public class PropertiesController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/user-service")
    public Props retrieveProps(){
        log.info("Inside properties controller");
        return new Props(configuration.getOne(),configuration.getTwo(),configuration.getThree());
    }
}
