package com.example.demo.security;

import com.example.demo.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	
	private Employee employee;

	private String jwtToken;

}
