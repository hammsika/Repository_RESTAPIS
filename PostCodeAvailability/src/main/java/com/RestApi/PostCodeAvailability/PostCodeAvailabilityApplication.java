package com.RestApi.PostCodeAvailability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostCodeAvailabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostCodeAvailabilityApplication.class, args);
	}
	@Bean
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
