package com.etiya.northwind.business.responses.orders;

import java.time.LocalDate;



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
	

	
	private double freight;
	
	private String shipName;
	
	
	private String shipAddress;
	
	private String shipCity;
	
	private String shipRegion;
	
	private String shipPostalCode;
	
	private String shipCountry;
	

	

	



}
