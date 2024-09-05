package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Client;
import com.example.demo.entity.Employee;

import jakarta.annotation.PostConstruct;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostConstruct
	public void initRoleAndAdmin() {
		employeeService.initRoleAndAdmin();
	}

	@PreAuthorize("hasRole('Employee')")
	@PostMapping("/addEmployee/{roleName}")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee, @PathVariable String roleName)
			throws Exception {

		Employee addEmployee = employeeService.addEmployee(employee, roleName);
		return new ResponseEntity<Employee>(addEmployee, HttpStatus.OK);
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<Employee> addAdmin(@RequestBody Employee admin) {

		Employee addAdmin = employeeService.addAdmin(admin);
		return new ResponseEntity<Employee>(addAdmin, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('Employee')")
	@GetMapping("/getAdmin/{employeeId}")
	public ResponseEntity<Employee> getAdmin(@PathVariable String employeeId) throws Exception {
		Employee admin = employeeService.getAdmin(employeeId);
		return new ResponseEntity<Employee>(admin, HttpStatus.OK);
	}
	
	@PostMapping("/createClient")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = employeeService.saveClient(client);
        return ResponseEntity.ok(savedClient);
    }
	
}
