package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.dataAccess.absracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerManager(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerListResponse> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> customerListResponses = new ArrayList<>();

		for (Customer customer : result) {
			CustomerListResponse customerListResponse = new CustomerListResponse();
			customerListResponse.setCustomerId(customer.getCustomerId());
			customerListResponse.setCompanyName(customer.getCompanyName());
			customerListResponse.setContactName(customer.getContactName());
			customerListResponse.setContactTitle(customer.getContactTitle());
			customerListResponse.setAddress(customer.getAddress());
			customerListResponse.setCity(customer.getCity());

			customerListResponses.add(customerListResponse);
		}
		return customerListResponses;
	}

}
