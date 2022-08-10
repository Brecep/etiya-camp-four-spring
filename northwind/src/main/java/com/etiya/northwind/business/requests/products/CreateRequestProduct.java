package com.etiya.northwind.business.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestProduct {
	
	private int productId;
	private String productName;
	private int supplierId;
	private int categoryId;

	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;
	
	private int unitsOnOrder;
	private int reorderLevel;
	private int discontinued;
	


}
