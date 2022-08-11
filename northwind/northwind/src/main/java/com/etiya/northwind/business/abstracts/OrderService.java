package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.orders.CreateRequestOrder;
import com.etiya.northwind.business.requests.orders.DeleteRequestOrder;
import com.etiya.northwind.business.requests.orders.UpdateRequestOrder;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface OrderService {

	DataResult<List<OrderListResponse>> getAll();
	Result add(CreateRequestOrder createRequestOrder);
	Result update(UpdateRequestOrder updateRequestOrder);
	Result delete(DeleteRequestOrder deleteRequestOrder);
	DataResult<GetOrderResponse> getById(int orderId);
	
	
	DataResult<List<OrderListResponse>> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
	
	
//	List<Order> findOrdersWithSort(String field);
//    Page<Order> findOrdersWithPagination(int offset, int pageSize);
//    Page<Order> findOrdersWithPaginationAndSorting(int offset, int pageSize, String field);
}
