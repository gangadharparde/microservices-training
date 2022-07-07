package com.gd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeConsumerEurekaRibbonHystrix4 {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeConsumerEurekaRibbonHystrix4.class, args);
	}
}

