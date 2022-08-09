package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/getall")
	public List<CustomerListResponse> getAll() {

		return this.customerService.getAll();
	}

}
