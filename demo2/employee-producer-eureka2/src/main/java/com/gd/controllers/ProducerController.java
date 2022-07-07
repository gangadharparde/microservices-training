package com.gd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gd.model.Employee;

@RestController
public class ProducerController {


	@GetMapping(value = "/info")
    public String getAllTodos() {
        return "This is 'employee-producer-eureka2' service";
    }
	@GetMapping(value = "/employee")
	public Employee firstPage() {
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		return emp;
	}

}
