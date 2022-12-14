package com.etiya.northwind.business.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequestSupplier {

	private int supplierId;

	private String companyName;

	private String contactName;

	private String contactTitle;

	private String address;


	private String region;

	private String postalCode;

	

	
	private String phone;
	
	private String fax;

	private String homepage;
	private int cityId;
	private int countryId;
}
