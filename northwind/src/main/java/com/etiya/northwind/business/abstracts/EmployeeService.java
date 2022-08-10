package com.etiya.northwind.business.abstracts;

import java.util.List;

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
}
