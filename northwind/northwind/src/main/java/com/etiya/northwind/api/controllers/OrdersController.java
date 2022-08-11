package com.etiya.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderService;

import com.etiya.northwind.business.requests.orders.CreateRequestOrder;
import com.etiya.northwind.business.requests.orders.DeleteRequestOrder;
import com.etiya.northwind.business.requests.orders.UpdateRequestOrder;

import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	
	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<OrderListResponse>> getAll(){
		return this.orderService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CreateRequestOrder createRequestOrder) {
		return this.orderService.add(createRequestOrder);
	}
	
	@GetMapping("/getById")
	public DataResult<GetOrderResponse> getById(int orderId){
		return this.orderService.getById(orderId);
		
		
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateRequestOrder updateRequestOrder) {
		return this.orderService.update(updateRequestOrder);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteRequestOrder deleteRequestOrder) {
		return this.orderService.delete(deleteRequestOrder);
	}
//	
//	@GetMapping("/{field}")
//    private ApiResponse<List<Order>> getOrdersWithSort(@PathVariable String field) {
//        List<Order> allOrders = orderService.findOrdersWithSort(field);
//        return new ApiResponse<>(allOrders.size(), allOrders);
//    }
//
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    private ApiResponse<Page<Order>> getOrdersWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Order> ordersWithPagination = orderService.findOrdersWithPagination(offset, pageSize);
//        return new ApiResponse<>(ordersWithPagination.getSize(), ordersWithPagination);
//    }
//
//    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//    private ApiResponse<Page<Order>> getOrdersWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//        Page<Order> ordersWithPagination = orderService.findOrdersWithPaginationAndSorting(offset, pageSize, field);
//        return new ApiResponse<>(ordersWithPagination.getSize(), ordersWithPagination);
//    }
    
    @GetMapping("/getAllPages")
	public DataResult<List<OrderListResponse>> getAllPages(int pageNo, int pageSize){
		return this.orderService.getAllPages(pageNo , pageSize);
	}
	
	@GetMapping("/getAllPagesSort")
    public Map<String,Object> getAllPagesSort(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.orderService.getAllPagesSort(pageNo,pageSize, entity,type.orElse(""));

    }

	

}
