package com.learn.scarycoders.reactivewebflux.reactiverestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveRestServiceApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ReactiveRestServiceApplication.class, args);
		final GreetingClient greetingClient = configurableApplicationContext.getBean(GreetingClient.class);
		System.out.println("Message>>> "+greetingClient.getMessage());
		System.out.println("after block");
	}

}
