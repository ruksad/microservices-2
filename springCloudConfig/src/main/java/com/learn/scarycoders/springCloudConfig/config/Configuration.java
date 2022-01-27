package com.learn.scarycoders.springCloudConfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties("spring-cloud-config-user-props")
@Getter
@Setter
public class Configuration {
    private int one;
    private int two;
    private int three;
    public String Uri;
}
