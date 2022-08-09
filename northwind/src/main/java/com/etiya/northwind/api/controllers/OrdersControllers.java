package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;

@RestController
@RequestMapping("/api/orders")
public class OrdersControllers {

	private OrderService orderService;

	public OrdersControllers(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping("/getall")
	public List<OrderListResponse> getAll() {
		return this.orderService.getAll();
	}
}
