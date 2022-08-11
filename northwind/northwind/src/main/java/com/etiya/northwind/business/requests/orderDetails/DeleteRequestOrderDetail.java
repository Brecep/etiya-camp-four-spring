package com.etiya.northwind.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRequestOrderDetail {

	private int orderId;
	private int productId;
}
