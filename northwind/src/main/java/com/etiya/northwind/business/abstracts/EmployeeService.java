package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;

public interface EmployeeService {
	
	List<EmployeeListResponse> getAll();
	void add(CreateRequestEmployee createRequestEmployee);
	void update(UpdateRequestEmployee updateRequestEmployee);
	void delete(DeleteRequestEmployee deleteRequestEmployee);
	GetEmployeeResponse getById(int employeeId);
	
	
	List<EmployeeListResponse> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
	
//	List<Employee> findEmployeeWithSort(String field);
//    Page<Employee> findEmployeeWithPagination(int offset, int pageSize);
//    Page<Employee> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field);
}
