package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.orderDetails.CreateRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.DeleteRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.UpdateRequestOrderDetail;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;

public interface OrderDetailService {
	
	List<OrderDetailListResponse> getAll();
	void add(CreateRequestOrderDetail createRequestOrderDetail);
	void update(UpdateRequestOrderDetail updateRequestOrderDetail);
//	void delete(DeleteRequestOrderDetail deleteRequestOrderDetail);
	//GetOrderDetailResponse getById(int orderId, int productId);

}
