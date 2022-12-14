package com.etiya.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

	@Id
	@Column(name="country_id")
	private int countryId;
	
	@Column(name = "country_name" )
	private String countryName;
	
	@OneToMany(mappedBy = "country")
	private List<City> cities;
	
	@OneToMany(mappedBy = "country")
	private List<Supplier> suppliers;
	
	@OneToMany(mappedBy = "country")
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "country")
	private List<Employee> employees;
}
