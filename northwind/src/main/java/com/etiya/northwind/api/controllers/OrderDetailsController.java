package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.requests.orderDetails.CreateRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.DeleteRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.UpdateRequestOrderDetail;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

private OrderDetailService orderDetailService;

	
	@Autowired
	public OrderDetailsController(OrderDetailService orderDetailService) {
		
		this.orderDetailService = orderDetailService;
	} 
	
	@GetMapping("/getAll")
	public List<OrderDetailListResponse> getAll(){
		return this.orderDetailService.getAll();
	}
	

	@PostMapping("/add")
	public void add(@RequestBody CreateRequestOrderDetail createRequestOrderDetail) {
		this.orderDetailService.add(createRequestOrderDetail);
	}
	
//	@GetMapping("/getById")
//	public GetOrderDetailResponse getById(int orderId,int productId){
//		return this.orderDetailService.getById(orderId,productId);
//		
//		
//	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateRequestOrderDetail updateRequestOrderDetail) {
		this.orderDetailService.update(updateRequestOrderDetail);
	}
	
//	@PostMapping("/delete")
//	public void delete(@RequestBody DeleteRequestOrderDetail deleteRequestOrderDetail) {
//		this.orderDetailService.delete(deleteRequestOrderDetail);
//	}
}
