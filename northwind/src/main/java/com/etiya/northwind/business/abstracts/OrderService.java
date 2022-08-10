package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


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
	
	
	List<OrderListResponse> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
	
	
//	List<Order> findOrdersWithSort(String field);
//    Page<Order> findOrdersWithPagination(int offset, int pageSize);
//    Page<Order> findOrdersWithPaginationAndSorting(int offset, int pageSize, String field);
}
