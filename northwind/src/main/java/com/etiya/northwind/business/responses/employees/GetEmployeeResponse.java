package com.etiya.northwind.business.responses.employees;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {

	
	private int employeeId;

	private String lastName;

	private String firstName;

	private String title;

	private String titleOfCourtesy;

	private LocalDate birthDate;

	private LocalDate hireDate;

	private String address;

	private String city;

	private String region;

	private String postalCode;

	private String country;
	
}
