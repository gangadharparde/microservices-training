package com.gd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//While @EnableDiscoveryClient will register dicovery service using the jar available in classpath like consul, Eureka, Kubernetes.
//There are multiple implementations of "Discovery Service" (eureka, consul, zookeeper). 
//@EnableDiscoveryClient lives in spring-cloud-commons and picks the implementation on the classpath. 
//@EnableEurekaClient lives in spring-cloud-netflix and only works for eureka. If eureka is on your classpath, they are effectively the same.

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeProducerEureka2 {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProducerEureka2.class, args);
	}
}
