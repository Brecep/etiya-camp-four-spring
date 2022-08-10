package com.etiya.northwind.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
	
	private int productId;
	private String productName;
	private int supplierId;
	private int categoryId;
	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;

}
