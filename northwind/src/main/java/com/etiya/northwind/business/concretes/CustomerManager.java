package com.etiya.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//	public List<Customer> findCustomersWithSorting(String field) {
//		 return  customerRepository.findAll(Sort.by(Sort.Direction.ASC,field));
//
//	}
//
//	@Override
//	public Page<Customer> findCustomersWithPagination(int offset, int pageSize) {
//		 Page<Customer> customers = customerRepository.findAll(PageRequest.of(offset, pageSize));
//	        return  customers;
//	}
//
//	@Override
//	public Page<Customer> findCustomersWithPaginationAndSorting(int offset, int pageSize, String field) {
//		Page<Customer> customers = customerRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return  customers;
//	}

	
	


	@Override
	public void delete(DeleteRequestCustomer deleteRequestCustomer) {
		
        this.customerRepository.deleteById(deleteRequestCustomer.getCustomerId());
	}

	@Override
	public GetCustomerResponse getcustomerId(String customerId) {
		   Customer customer = this.customerRepository.getById(customerId);
	        GetCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
	        return response;
	}
	
	

	@Override
	public List<CustomerListResponse> getAllPages(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		List<Customer> customers = this.customerRepository.findAll(pageable).getContent();
		List<CustomerListResponse> response = customers.stream().map(customer->
		this.modelMapperService.forResponse().map(customer, CustomerListResponse.class)).collect(
				Collectors.toList());
		
		int currentPage = pageNo;
		int totalDatas = customers.size();
		int totalPages = (int) Math.ceil(totalDatas/pageSize);
		
		return response;
	}

	@Override
	public Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type) {
		
		Pageable pageable=PageRequest.of(pageNo-1,pageSize,sortType(entity,type));


        Map<String,Object> response=new HashMap<>();
        Page<Customer> customers =customerRepository.findAll(pageable);
        response.put("totalElements",customers.getTotalElements()) ;
        response.put("totalPages",customers.getTotalPages());
        response.put("currentPage",customers.getNumber()+1);
        response.put("customers",customers.getContent().stream().map(customer ->
                this.modelMapperService.forResponse().map(customer,CustomerListResponse.class)).collect(Collectors.toList()));

        return response ;
    }


 public Sort sortType(String property,String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }
	




	
	
	
	
	

}
