package com.etiya.northwind.business.responses.orders;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListResponse {

	
	private int orderId;
	
	private String customerCompanyName;
	
	private String employeeFirstName;
	private String employeeLastName;
	
	private Date orderDate;
	
	private String contactName;
	private String employeeFullName;
	
}
