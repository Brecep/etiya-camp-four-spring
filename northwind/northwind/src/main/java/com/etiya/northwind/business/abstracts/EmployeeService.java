package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface EmployeeService {
	
	DataResult<List<EmployeeListResponse>> getAll();
	Result add(CreateRequestEmployee createRequestEmployee);
	Result update(UpdateRequestEmployee updateRequestEmployee);
	Result delete(DeleteRequestEmployee deleteRequestEmployee);
	DataResult<GetEmployeeResponse> getById(int employeeId);
	
	
	DataResult<List<EmployeeListResponse>> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
	
//	List<Employee> findEmployeeWithSort(String field);
//    Page<Employee> findEmployeeWithPagination(int offset, int pageSize);
//    Page<Employee> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field);
}
