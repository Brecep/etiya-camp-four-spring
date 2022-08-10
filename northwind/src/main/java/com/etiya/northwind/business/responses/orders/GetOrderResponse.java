package com.etiya.northwind.business.responses.orders;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {

	
	private int orderId;
	
	private String customerId;

	
	private int employeeId;

	private LocalDate orderDate;

	private LocalDate requiredDate;

	private LocalDate shippedDate;
	
	private int shipVia;
	
	private double freight;
	
	private String shipName;
	
	
	private String shipAddress;
	
	private String shipCity;
	
	private String shipRegion;
	
	private String shipPostalCode;
	
	private String shipCountry;
	

	

	



}
