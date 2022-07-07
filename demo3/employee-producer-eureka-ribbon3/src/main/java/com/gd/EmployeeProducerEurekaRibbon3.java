package com.gd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeProducerEurekaRibbon3 {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProducerEurekaRibbon3.class, args);
	}
}
