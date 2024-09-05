package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	@Id
	private String companyId;
	private String companyName;
	private String companyStrength;
	private String companyRole;
	private String portalLink;
	private String companyLink;
	private String experience;
	private String jobDescription;
	private Long contactNumber;
	private String location;

}
