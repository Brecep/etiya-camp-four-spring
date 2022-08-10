package com.etiya.northwind.business.abstracts;

import java.util.List;


import com.etiya.northwind.business.requests.orders.CreateRequestOrder;
import com.etiya.northwind.business.requests.orders.DeleteRequestOrder;
import com.etiya.northwind.business.requests.orders.UpdateRequestOrder;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;

public interface OrderService {

	List<OrderListResponse> getAll();
	void add(CreateRequestOrder createRequestOrder);
	void update(UpdateRequestOrder updateRequestOrder);
	void delete(DeleteRequestOrder deleteRequestOrder);
	GetOrderResponse getById(int orderId);
}
