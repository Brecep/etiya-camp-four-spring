package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.requests.customers.CreateRequestCustomer;
import com.etiya.northwind.business.requests.customers.DeleteRequestCustomer;
import com.etiya.northwind.business.requests.customers.UpdateRequestCustomer;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	
	@Autowired
	public CustomersController(CustomerService customerService) {
		
		this.customerService = customerService;
	} 
	
	@GetMapping("/getAll")
	public List<CustomerListResponse> getAll(){
		return this.customerService.getAll();
	}
	

	@PostMapping("/add")
	public void add(@RequestBody CreateRequestCustomer createRequestCustomer) {
		this.customerService.add(createRequestCustomer);
	}
	
//	@GetMapping("/getById")
//	public GetCustomerResponse getById(String customerId){
//		return this.customerService.getById(customerId);
//		
//		
//	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateRequestCustomer updateRequestCustomer) {
		this.customerService.update(updateRequestCustomer);
	}
	
//	@PostMapping("/delete")
//	public void delete(@RequestBody DeleteRequestCustomer deleteRequestCustomer) {
//		this.customerService.delete(deleteRequestCustomer);
//	}
}
