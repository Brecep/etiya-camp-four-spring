package com.etiya.northwind.business.requests.orders;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequestOrder {

	
	private int orderId;

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
	

	
	private int quantity;
	
	private double unitPrice;
	

	private String customerId;

	
	private int employeeId;
}
