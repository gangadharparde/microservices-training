package com.gd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeConsumerEurekaRibbon3 {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeConsumerEurekaRibbon3.class, args);
	}
}

