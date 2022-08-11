package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.customers.CreateRequestCustomer;
import com.etiya.northwind.business.requests.customers.DeleteRequestCustomer;
import com.etiya.northwind.business.requests.customers.UpdateRequestCustomer;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;

public interface CustomerService {
	
	List<CustomerListResponse> getAll();
	void add(CreateRequestCustomer createRequestCustomer);
	void update(UpdateRequestCustomer updateRequestCustomer);
	
	
	void delete(DeleteRequestCustomer deleteRequestCustomer);
	GetCustomerResponse getcustomerId(String customerId);
	
	List<CustomerListResponse> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
//	List<Customer> findCustomersWithSorting(String field);
//	   Page<Customer> findCustomersWithPagination(int offset,int pageSize);
//	   Page<Customer> findCustomersWithPaginationAndSorting(int offset,int pageSize,String field);
}
