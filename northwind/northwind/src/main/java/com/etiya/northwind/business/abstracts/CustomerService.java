package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;

import com.etiya.northwind.business.requests.customers.CreateRequestCustomer;
import com.etiya.northwind.business.requests.customers.DeleteRequestCustomer;
import com.etiya.northwind.business.requests.customers.UpdateRequestCustomer;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CustomerService {

	DataResult<List<CustomerListResponse>> getAll();

	Result add(CreateRequestCustomer createRequestCustomer);

	Result update(UpdateRequestCustomer updateRequestCustomer);

	Result delete(DeleteRequestCustomer deleteRequestCustomer);

	DataResult<GetCustomerResponse> getcustomerId(String customerId);

	DataResult<List<CustomerListResponse>> getAllPages(int pageNo, int pageSize);

	Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type);

//	List<Customer> findCustomersWithSorting(String field);
//	   Page<Customer> findCustomersWithPagination(int offset,int pageSize);
//	   Page<Customer> findCustomersWithPaginationAndSorting(int offset,int pageSize,String field);
}
