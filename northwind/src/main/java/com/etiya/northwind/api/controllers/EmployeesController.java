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

import com.etiya.northwind.business.abstracts.EmployeeService;

import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;

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
	
//	  @GetMapping("/{field}")
//	    private ApiResponse<List<Employee>> getEmployeesWithSort(@PathVariable String field) {
//	        List<Employee> allEmployees = employeeService.findEmployeeWithSort(field);
//	        return new ApiResponse<>(allEmployees.size(), allEmployees);
//	    }
//
//	    @GetMapping("/pagination/{offset}/{pageSize}")
//	    private ApiResponse<Page<Employee>> getEmployeesWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//	        Page<Employee> employeessWithPagination = employeeService.findEmployeeWithPagination(offset, pageSize);
//	        return new ApiResponse<>(employeessWithPagination.getSize(), employeessWithPagination);
//	    }
//
//	    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//	    private ApiResponse<Page<Employee>> getEmployeesWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//	        Page<Employee> employeesWithPagination = employeeService.findEmployeesWithPaginationAndSorting(offset, pageSize, field);
//	        return new ApiResponse<>(employeesWithPagination.getSize(), employeesWithPagination);
//	    }

	@GetMapping("/getAllPages")
	public List<EmployeeListResponse> getAllPages(int pageNo, int pageSize){
		return this.employeeService.getAllPages(pageNo , pageSize);
	}
	
	@GetMapping("/getAllPagesSort")
    public Map<String,Object> getAllPagesSort(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.employeeService.getAllPagesSort(pageNo,pageSize, entity,type.orElse(""));

    }
	
	
}
