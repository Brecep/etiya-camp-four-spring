package com.etiya.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.requests.orders.CreateRequestOrder;
import com.etiya.northwind.business.requests.orders.DeleteRequestOrder;
import com.etiya.northwind.business.requests.orders.UpdateRequestOrder;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/getAll")
	public List<OrderListResponse> getAll(){
		return this.orderService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateRequestOrder createRequestOrder) {
		this.orderService.add(createRequestOrder);
	}
	
	@GetMapping("/getById")
	public GetOrderResponse getById(int orderId){
		return this.orderService.getById(orderId);
		
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateRequestOrder updateRequestOrder) {
		this.orderService.update(updateRequestOrder);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteRequestOrder deleteRequestOrder) {
		this.orderService.delete(deleteRequestOrder);
	}
	

}
