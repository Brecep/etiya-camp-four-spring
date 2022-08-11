package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.orderDetails.CreateRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.DeleteRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.UpdateRequestOrderDetail;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface OrderDetailService {
	
	DataResult<List<OrderDetailListResponse>> getAll();
	Result add(CreateRequestOrderDetail createRequestOrderDetail);
	Result update(UpdateRequestOrderDetail updateRequestOrderDetail);
	Result delete(DeleteRequestOrderDetail deleteRequestOrderDetail);
	DataResult<GetOrderDetailResponse> getById(int orderId,int productId);
	
//	List<OrderDetail> findOrderDetailsWithSort(String field);
//    Page<OrderDetail> findOrderDetailsWithPagination(int offset, int pageSize);
//    Page<OrderDetail> findOrderDetailsWithPaginationAndSorting(int offset, int pageSize, String field);
	
	DataResult<List<OrderDetailListResponse>> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	

}
