package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateRequestOrder;
import com.etiya.northwind.business.requests.orders.DeleteRequestOrder;
import com.etiya.northwind.business.requests.orders.UpdateRequestOrder;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderManager implements OrderService {

	
	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;
	public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
		
		this.orderRepository = orderRepository;
		this.modelMapperService = modelMapperService;
	}




	@Override
	public DataResult<List<OrderListResponse>> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> response = result.stream().map(order->
		this.modelMapperService.forResponse().map(order, OrderListResponse.class)).collect(Collectors.toList());
		
		 for(int i= 0 ; i<response.size();i++) {
			 response.get(i).setEmployeeFullName(result.get(i).getEmployee().getFirstName()+" "+result.get(i).getEmployee().getLastName());
		 }
		
		return new SuccessDataResult<List<OrderListResponse>>(response);
	}




	@Override
	public Result add(CreateRequestOrder createRequestOrder) {
		Order order = this.modelMapperService.forRequest().
				map(createRequestOrder, Order.class);
		this.orderRepository.save(order);
		return new SuccessResult("Order added");
		
	}




	@Override
	public Result update(UpdateRequestOrder updateRequestOrder) {
		Order order = this.modelMapperService.forResponse().map(updateRequestOrder, Order.class);
		this.orderRepository.save(order);
		return new SuccessResult("Order updated");		
	}




	@Override
	public Result delete(DeleteRequestOrder deleteRequestOrder) {
		this.orderRepository.deleteById(deleteRequestOrder.getOrderId());
		return new SuccessResult("Order deleted");
		
	}




	@Override
	public DataResult<GetOrderResponse> getById(int orderId) {
		Optional<Order> order = this.orderRepository.findById(orderId);
		GetOrderResponse getOrderResponse = this.modelMapperService.forResponse().map(order, GetOrderResponse.class);	
		return new SuccessDataResult<GetOrderResponse>(getOrderResponse);
	}




//	@Override
//	public List<Order> findOrdersWithSort(String field) {
//        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, field));
//
//	}
//
//
//
//
//	@Override
//	public Page<Order> findOrdersWithPagination(int offset, int pageSize) {
//		Page<Order> orders = orderRepository.findAll(PageRequest.of(offset, pageSize));
//        return orders;
//	}
//
//
//
//
//	@Override
//	public Page<Order> findOrdersWithPaginationAndSorting(int offset, int pageSize, String field) {
//		Page<Order> orders = orderRepository.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.ASC, field)));
//        return orders;
//	}




	@Override
	public DataResult<List<OrderListResponse>> getAllPages(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		List<Order> orders = this.orderRepository.findAll(pageable).getContent();
		List<OrderListResponse> response = orders.stream().map(order->
		this.modelMapperService.forResponse().map(order, OrderListResponse.class)).collect(
				Collectors.toList());
		
		int currentPage = pageNo;
		int totalDatas = orders.size();
		int totalPages = (int) Math.ceil(totalDatas/pageSize);
		
		return new SuccessDataResult<List<OrderListResponse>>(response);
	}




	@Override
	public Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type) {
		Pageable pageable=PageRequest.of(pageNo-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<Order> orders =orderRepository.findAll(pageable);
        response.put("totalElements",orders.getTotalElements()) ;
        response.put("totalPages",orders.getTotalPages());
        response.put("currentPage",orders.getNumber()+1);
        response.put("customers",orders.getContent().stream().map(order ->
                this.modelMapperService.forResponse().map(order,OrderListResponse.class)).collect(Collectors.toList()));

        return response ;
	}
	
	 public Sort sortType(String property,String type){
	        if(type.equals("desc"))
	            return Sort.by(property).descending();
	        else return Sort.by(property).ascending() ;

	}

}
