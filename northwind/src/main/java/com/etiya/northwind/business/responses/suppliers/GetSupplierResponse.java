package com.etiya.northwind.business.responses.suppliers;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSupplierResponse {


	private int supplierId;

	private String companyName;

	private String contactName;

	private String contactTitle;

	private String address;

	private String city;

	private String region;

	private String postalCode;

	
	private String country;
	
	private String phone;
	
	private String fax;

	private String homepage;
}
