package com.etiya.northwind.business.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierListResponse {

	private int supplierId;
	private String companyName;
	private String contactTitle;
	private int cityId;
	private int countryId;
}
