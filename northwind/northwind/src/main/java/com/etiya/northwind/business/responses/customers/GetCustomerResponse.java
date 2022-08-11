package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {

	private String customerId;

	private String companyName;

	private String contactName;

	private String contactTitle;

	private String address;



	private String region;

	 private String postalCode;

	
	
	 private String phone;
	  
	private String fax;
	private int cityId;
	private int countryId;
	private String cityName;
	private String countryName;
	
}
