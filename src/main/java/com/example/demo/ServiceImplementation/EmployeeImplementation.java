package com.example.demo.ServiceImplementation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repoisitory.ClientRepoisitory;
import com.example.demo.Repoisitory.EmployeeRepository;
import com.example.demo.Repoisitory.roleRepository;
import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Client;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;

@Service
public class EmployeeImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private roleRepository roleRepository;

	@Autowired
	private ClientRepoisitory clientRepoisitory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String getEncodedPassword(String employeePassword) {
		return passwordEncoder.encode(employeePassword);
	}

	@Override
	public String initRoleAndAdmin() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		roleRepository.save(adminRole);

		Role teamleadRole = new Role();
		teamleadRole.setRoleName("Employee");
		roleRepository.save(teamleadRole);

		return "Success";
	}

	@Override
	public Employee addEmployee(Employee employee, String roleName) throws Exception {
		Role role = roleRepository.findById(roleName).get();
		Set<Role> employeeRole = new HashSet<>();
		employeeRole.add(role);
		employee.setRoles(employeeRole);

		// Store the original password before encoding
		String originalPassword = employee.getEmployeePassword();

		// Encode the password and set it to the employee object
		String encodedPassword = getEncodedPassword(originalPassword);
		employee.setEmployeePassword(encodedPassword);

		return employeeRepository.save(employee);
	}

	@Override
	public Employee addAdmin(Employee admin) {

		Role role = roleRepository.findById("Admin").get();
		Set<Role> adminRole = new HashSet<>();
		adminRole.add(role);
		admin.setRoles(adminRole);
		String encodedPassword = getEncodedPassword(admin.getEmployeePassword());
		admin.setEmployeePassword(encodedPassword);
		return employeeRepository.save(admin);
	}

	@Override
	public Employee getAdmin(String employeeId) throws Exception {

		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isEmpty()) {
			throw new Exception("give Valid AdminId");
		} else {
			return employee.get();
		}
	}
	
	 @Override
	    public Client saveClient(Client client) {
	        return clientRepoisitory.save(client);
	    }

}
