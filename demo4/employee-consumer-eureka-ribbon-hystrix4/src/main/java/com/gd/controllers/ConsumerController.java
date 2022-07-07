package com.gd.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private LoadBalancerClient loadBalancer;

	@GetMapping(value = "/info", produces = "text/plain")
	public String getInfo() {
		return getEmployee();
	}

	public String getEmployee() {
		StringBuilder responseText = new StringBuilder(
				"This is 'employee-consumer-eureka-ribbon-hystrix4' service \n\n\nAvailable producer instances (ONLY ONE POST LOAD BALANCING).\n");

		ServiceInstance serviceInstance = loadBalancer.choose("employee-producer-ribbon-hystrix");
		System.out.println("Using the only producer serivce got from LoadBalancerClient:" + serviceInstance.getUri());
		responseText.append("Using the only producer serivce got from LoadBalancerClient:\n" + serviceInstance.getUri());
		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/employee";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		responseText.append("\n\n\n" + response.getBody());
		return responseText.toString();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}