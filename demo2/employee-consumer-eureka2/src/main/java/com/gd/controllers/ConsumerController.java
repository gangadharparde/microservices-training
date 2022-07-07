package com.gd.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient discoveryClient;

	@GetMapping(value = "/info", produces="text/plain")
	public String getAllTodos() {
		return getEmployee();
	}

	public String getEmployee()  {
		StringBuilder responseText = new 
                StringBuilder("This is 'employee-consumer-eureka2' service \n\n\nAvailable producer instances:");
		
		List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
		for (int i = 0; i < instances.size(); i++) {
			System.out.println("[" + i + "]  -->  " + instances.get(i).getUri());
			responseText.append("\n[" + i + "]  -->  " + instances.get(i).getUri());
		}
		System.out.println("Using the first producer serivce got from DiscoveryClient:" + instances.get(0).getUri());
		responseText.append("\n\n\nUsing the first serivce:\n" + instances.get(0).getUri());
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/employee";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		responseText.append("\n\n\n"+response.getBody());
		return responseText.toString();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}