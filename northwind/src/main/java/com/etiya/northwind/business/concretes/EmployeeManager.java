package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
		super();
		this.employeeRepository = employeeRepository;
		this.modelMapperService = modelMapperService;
	}





	@Override
	public List<EmployeeListResponse> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> response = result.stream().map(employee->this.modelMapperService.forResponse()
				.map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
		
		
		return response;
	}



	@Override
	public void add(CreateRequestEmployee createRequestEmployee) {
		Employee employee = this.modelMapperService.forRequest().
				map(createRequestEmployee, Employee.class);
		this.employeeRepository.save(employee);
		
	}



	@Override
	public void update(UpdateRequestEmployee updateRequestEmployee) {
		Employee employee = this.modelMapperService.forResponse().map(updateRequestEmployee, Employee.class);
		this.employeeRepository.save(employee);
		
	}


	@Override
	public void delete(DeleteRequestEmployee deleteRequestEmployee) {
		this.employeeRepository.deleteById(deleteRequestEmployee.getEmployeeId());
		
	}


	@Override
	public GetEmployeeResponse getById(int employeeId) {
		Employee employee = this.employeeRepository.getById(employeeId);
		GetEmployeeResponse getEmployeeResponse = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);	
		return getEmployeeResponse;
	}

}
