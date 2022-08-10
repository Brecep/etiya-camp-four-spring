package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

private EmployeeService employeeService;

	
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	} 
	
	@GetMapping("/getAll")
	public List<EmployeeListResponse> getAll(){
		return this.employeeService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateRequestEmployee createRequestEmployee) {
		this.employeeService.add(createRequestEmployee);
	}
	
	@GetMapping("/getById")
	public GetEmployeeResponse getById(int employeeId){
		return this.employeeService.getById(employeeId);
		
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateRequestEmployee updateRequestEmployee) {
		this.employeeService.update(updateRequestEmployee);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteRequestEmployee deleteRequestEmployee) {
		this.employeeService.delete(deleteRequestEmployee);
	}
}
