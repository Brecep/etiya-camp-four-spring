package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.dataAccess.absracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;

@Service
public class OrderManager implements OrderService {

	private OrderRepository orderRepository;

	public OrderManager(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public List<OrderListResponse> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = new ArrayList<>();
		for (Order order : result) {
			OrderListResponse orderListResponse = new OrderListResponse();
			orderListResponse.setOrderId(order.getOrderId());
			orderListResponse.setOrderDate(order.getOrderDate());
			orderListResponse.setRequiredDate(order.getRequiredDate());
			orderListResponse.setCustomerId(order.getCustomer().getCustomerId());
			//orderListResponse.setEmployeeId(order.getEmployee().getEmployeeId());

			response.add(orderListResponse);
		}
		return response;
	}

}
