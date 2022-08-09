package com.etiya.northwind.business.responses.employees;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListResponse {

	private int employeeId;

	private String lastName;

	private String firstName;

	private String title;

	private String titleOfCourtesy;

	private LocalDate birtDate;

}
