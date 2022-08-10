package com.etiya.northwind.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequestOrderDetail {

private int orderId;
	
	private int productId;
	private String productName;
	
	private double unitPrice;
	private int quantity;
	private double discount;
}
