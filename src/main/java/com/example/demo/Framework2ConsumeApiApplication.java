package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Framework2ConsumeApiApplication {

	public static void main(String[] args) {
            SpringApplication.run(Framework2ConsumeApiApplication.class, args);
	}
        
        @Bean
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }

}
