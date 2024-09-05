package com.example.demo.Service;

import com.example.demo.entity.Client;
import com.example.demo.entity.Employee;

public interface EmployeeService {

	String initRoleAndAdmin();

	public Employee addEmployee(Employee employee, String roleName) throws Exception;

	public Employee addAdmin(Employee admin);

	public Employee getAdmin(String employeeId) throws Exception;

	Client saveClient(Client client);
	}
