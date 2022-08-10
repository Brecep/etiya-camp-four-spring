package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateRequestOrder;
import com.etiya.northwind.business.requests.orders.DeleteRequestOrder;
import com.etiya.northwind.business.requests.orders.UpdateRequestOrder;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.Order;

@Service
public class OrderManager implements OrderService {

	
	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;
	public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
		
		this.orderRepository = orderRepository;
		this.modelMapperService = modelMapperService;
	}




	@Override
	public List<OrderListResponse> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = result.stream().map(order->
		this.modelMapperService.forResponse().map(order, OrderListResponse.class)).collect(Collectors.toList());
		
		 for(int i= 0 ; i<response.size();i++) {
			 response.get(i).setEmployeeFullName(result.get(i).getEmployee().getFirstName()+" "+result.get(i).getEmployee().getLastName());
		 }
		
		return response;
	}




	@Override
	public void add(CreateRequestOrder createRequestOrder) {
		Order order = this.modelMapperService.forRequest().
				map(createRequestOrder, Order.class);
		this.orderRepository.save(order);
		
	}




	@Override
	public void update(UpdateRequestOrder updateRequestOrder) {
		Order order = this.modelMapperService.forResponse().map(updateRequestOrder, Order.class);
		this.orderRepository.save(order);		
	}




	@Override
	public void delete(DeleteRequestOrder deleteRequestOrder) {
		this.orderRepository.deleteById(deleteRequestOrder.getOrderId());
		
	}




	@Override
	public GetOrderResponse getById(int orderId) {
		Optional<Order> order = this.orderRepository.findById(orderId);
		GetOrderResponse getOrderResponse = this.modelMapperService.forResponse().map(order, GetOrderResponse.class);	
		return getOrderResponse;
	}

}
