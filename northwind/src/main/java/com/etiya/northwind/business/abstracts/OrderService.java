package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.responses.orders.OrderListResponse;

public interface OrderService {
	public List<OrderListResponse> getAll();
}
