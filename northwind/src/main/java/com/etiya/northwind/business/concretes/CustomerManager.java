package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateRequestCustomer;
import com.etiya.northwind.business.requests.customers.DeleteRequestCustomer;
import com.etiya.northwind.business.requests.customers.UpdateRequestCustomer;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;

	public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
	
		this.customerRepository = customerRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<CustomerListResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> response = result.stream().map(
				customer-> this.modelMapperService.forResponse().
				map(customer, CustomerListResponse.class)).collect(Collectors.toList());

		
		
		return response;
	}

	@Override
	public void add(CreateRequestCustomer createRequestCustomer) {
		Customer customer = this.modelMapperService.forRequest().
				map(createRequestCustomer, Customer.class);
		this.customerRepository.save(customer);
		
	}

	@Override
	public void update(UpdateRequestCustomer updateRequestCustomer) {
		Customer customer = this.modelMapperService.forRequest().map(updateRequestCustomer, Customer.class);
		this.customerRepository.save(customer);
		
	}

//	@Override
//	public void delete(DeleteRequestCustomer deleteRequestCustomer) {
//		this.customerRepository.deleteByName(deleteRequestCustomer.getCustomerId());
//	}

//	@Override
//	public GetCustomerResponse getById(String customerId) {
//		Customer customer = this.customerRepository.findByName(customerId);
//		GetCustomerResponse getCustomerResponse = this.modelMapperService.
//				forResponse().map(customer, GetCustomerResponse.class);
//		return getCustomerResponse;
//		
//	}
	
	
	
	
	

}
