package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.DeleteRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.UpdateRequestOrderDetail;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService {

	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
		
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}



	@Override
	public List<OrderDetailListResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = result.stream().map(orderDetail->
		this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList());
		
		
		return response;
	}



	@Override
	public void add(CreateRequestOrderDetail createRequestOrderDetail) {
		OrderDetail orderDetail = this.modelMapperService.forRequest().
				map(createRequestOrderDetail, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
	}



	@Override
	public void update(UpdateRequestOrderDetail updateRequestOrderDetail) {
		OrderDetail orderDetail = this.modelMapperService.forResponse().map(updateRequestOrderDetail, OrderDetail.class);
		this.orderDetailRepository.save(orderDetail);
		
	}



//	@Override
//	public void delete(DeleteRequestOrderDetail deleteRequestOrderDetail) {
//		this.orderDetailRepository.deleteByOrderIdAndProductId(deleteRequestOrderDetail.getOrderId() , deleteRequestOrderDetail.getProductId());
//		
//	}



//	@Override
//	public GetOrderDetailResponse getById(int orderId, int productId) {
//		OrderDetail orderDetail = this.orderDetailRepository.getById(orderId,productId);
//		GetOrderDetailResponse getOrderDetailResponse = this.modelMapperService.forResponse().map(orderDetail, GetOrderDetailResponse.class);	
//		return getOrderDetailResponse;
//	}

}
