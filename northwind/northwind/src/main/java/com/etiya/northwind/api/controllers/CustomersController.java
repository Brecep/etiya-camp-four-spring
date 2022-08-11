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

import com.etiya.northwind.business.abstracts.CustomerService;

import com.etiya.northwind.business.requests.customers.CreateRequestCustomer;
import com.etiya.northwind.business.requests.customers.DeleteRequestCustomer;
import com.etiya.northwind.business.requests.customers.UpdateRequestCustomer;

import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {

		this.customerService = customerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CustomerListResponse>> getAll() {
		return this.customerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateRequestCustomer createRequestCustomer) {
		return this.customerService.add(createRequestCustomer);
	}

	@GetMapping("/getById")
	public DataResult<GetCustomerResponse> getcustomerId(String customerId) {
		return this.customerService.getcustomerId(customerId);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateRequestCustomer updateRequestCustomer) {
		return this.customerService.update(updateRequestCustomer);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteRequestCustomer deleteRequestCustomer) {
		return this.customerService.delete(deleteRequestCustomer);
	}

//	@GetMapping("/{field}")
//    public ApiResponse<List<Customer>> getCustomersWithSort(@PathVariable String field) {
//        List<Customer> allCustomers = customerService.findCustomersWithSorting(field);
//        return new ApiResponse<>(allCustomers.size(), allCustomers);
//    }
//
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    public ApiResponse<Page<Customer>> getCustomersWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Customer> customersWithPagination = customerService.findCustomersWithPagination(offset, pageSize);
//        return new ApiResponse<>(customersWithPagination.getSize(),customersWithPagination);
//    }
//
//    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//    public ApiResponse<Page<Customer>> getCustomersWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//        Page<Customer> customersWithPagination = customerService.findCustomersWithPaginationAndSorting(offset, pageSize, field);
//        return new ApiResponse<>(customersWithPagination.getSize(), customersWithPagination);
//    }

	@GetMapping("/getAllPages")
	public DataResult<List<CustomerListResponse>> getAllPages(int pageNo, int pageSize) {
		return this.customerService.getAllPages(pageNo, pageSize);
	}

	@GetMapping("/getAllPagesSort")
	public Map<String, Object> getAllPagesSort(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestParam String entity, @RequestParam Optional<String> type) {

		return this.customerService.getAllPagesSort(pageNo, pageSize, entity, type.orElse(""));

	}
}
