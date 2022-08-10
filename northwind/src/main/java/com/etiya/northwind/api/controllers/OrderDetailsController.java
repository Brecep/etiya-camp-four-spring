package com.etiya.northwind.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.OrderDetailService;

import com.etiya.northwind.business.requests.orderDetails.CreateRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.DeleteRequestOrderDetail;
import com.etiya.northwind.business.requests.orderDetails.UpdateRequestOrderDetail;
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
	
	@GetMapping("/getById")
	public GetOrderDetailResponse getById(@RequestParam int orderId,@RequestParam int productId){
		return this.orderDetailService.getById(orderId,productId);
	
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateRequestOrderDetail updateRequestOrderDetail) {
		this.orderDetailService.update(updateRequestOrderDetail);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteRequestOrderDetail deleteRequestOrderDetail) {
		this.orderDetailService.delete(deleteRequestOrderDetail);
	}
	
	
//	  @GetMapping("/{field}")
//	    private ApiResponse<List<OrderDetail>> getOrderDetailsWithSort(@PathVariable String field) {
//	        List<OrderDetail> allOrderDetails = orderDetailService.findOrderDetailsWithSort(field);
//	        return new ApiResponse<>(allOrderDetails.size(), allOrderDetails);
//	    }
//
//	    @GetMapping("/pagination/{offset}/{pageSize}")
//	    private ApiResponse<Page<OrderDetail>> getOrderDetailsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//	        Page<OrderDetail> orderDetailsWithPagination = orderDetailService.findOrderDetailsWithPagination(offset, pageSize);
//	        return new ApiResponse<>(orderDetailsWithPagination.getSize(), orderDetailsWithPagination);
//	    }
//
//	    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//	    private ApiResponse<Page<OrderDetail>> getOrderDetailsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//	        Page<OrderDetail> orderDetailsWithPagination = orderDetailService.findOrderDetailsWithPaginationAndSorting(offset, pageSize, field);
//	        return new ApiResponse<>(orderDetailsWithPagination.getSize(), orderDetailsWithPagination);
//	    }
	
	@GetMapping("/getAllPages")
	public List<OrderDetailListResponse> getAllPages(int pageNo, int pageSize){
		return this.orderDetailService.getAllPages(pageNo , pageSize);
	}
	
	@GetMapping("/getAllPagesSort")
    public Map<String,Object> getAllPagesSort(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.orderDetailService.getAllPagesSort(pageNo,pageSize, entity,type.orElse(""));

    }

}
