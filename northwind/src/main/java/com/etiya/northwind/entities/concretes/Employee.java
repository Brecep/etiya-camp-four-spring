package com.etiya.northwind.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "title")
	private String title;

	@Column(name = "title_of_courtesy")
	private String titleOfCourtesy;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "hire_date")
	private LocalDate hireDate;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "region")
	private String region;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "employee")
	private List<Order> orders;

}