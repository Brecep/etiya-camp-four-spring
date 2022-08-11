package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListResponse {

	private String customerId;
	
	private String companyName;
	
	private String contactName;
	private String contactTitle;
	private String address;
	
	private int cityId;
	private String cityName;
	private String countryName;
	

}
