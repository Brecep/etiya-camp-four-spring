package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.customers.CreateRequestCustomer;
import com.etiya.northwind.business.requests.customers.DeleteRequestCustomer;
import com.etiya.northwind.business.requests.customers.UpdateRequestCustomer;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;

public interface CustomerService {
	
	List<CustomerListResponse> getAll();
	void add(CreateRequestCustomer createRequestCustomer);
	void update(UpdateRequestCustomer updateRequestCustomer);
//	void delete(DeleteRequestCustomer deleteRequestCustomer);
//	GetCustomerResponse getById(String customerId);
}
