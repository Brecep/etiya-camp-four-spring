package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateRequestEmployee;
import com.etiya.northwind.business.requests.employees.DeleteRequestEmployee;
import com.etiya.northwind.business.requests.employees.UpdateRequestEmployee;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
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
	public DataResult<List<EmployeeListResponse>> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> response = result.stream().map(employee->this.modelMapperService.forResponse()
				.map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
		
		
		return new SuccessDataResult<List<EmployeeListResponse>>(response);
	}



	@Override
	public Result add(CreateRequestEmployee createRequestEmployee) {
		checkEmployeesReportsTo(createRequestEmployee.getReportsTo());
		Employee employee = this.modelMapperService.forRequest().
				map(createRequestEmployee, Employee.class);
		this.employeeRepository.save(employee);
		return new SuccessResult("Employee added");
		
	}



	@Override
	public Result update(UpdateRequestEmployee updateRequestEmployee) {
		Employee employee = this.modelMapperService.forResponse().map(updateRequestEmployee, Employee.class);
		this.employeeRepository.save(employee);
		return new SuccessResult("Employee updated");
		
	}


	@Override
	public Result delete(DeleteRequestEmployee deleteRequestEmployee) {
		this.employeeRepository.deleteById(deleteRequestEmployee.getEmployeeId());
		return new SuccessResult("Employee deleted");
		
	}


	@Override
	public DataResult<GetEmployeeResponse> getById(int employeeId) {
		Employee employee = this.employeeRepository.getById(employeeId);
		GetEmployeeResponse getEmployeeResponse = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);	
		return new SuccessDataResult<GetEmployeeResponse>(getEmployeeResponse);
	}

//	 @Override
//	    public List<Employee> findEmployeeWithSort(String field) {
//	        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
//
//	    }
//
//	    @Override
//	    public Page<Employee> findEmployeeWithPagination(int offset, int pageSize) {
//	        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offset, pageSize));
//	        return employees;
//	    }
//
//	    @Override
//	    public Page<Employee> findEmployeesWithPaginationAndSorting(int offset, int pageSize, String field) {
//	        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.ASC, field)));
//	        return employees;
//	    }



		@Override
		public DataResult<List<EmployeeListResponse>> getAllPages(int pageNo, int pageSize) {
			
			Pageable pageable = PageRequest.of(pageNo-1, pageSize);
			List<Employee> employees = this.employeeRepository.findAll(pageable).getContent();
			List<EmployeeListResponse> response = employees.stream().map(employee->
			this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class)).collect(
					Collectors.toList());
			
			int currentPage = pageNo;
			int totalDatas = employees.size();
			int totalPages = (int) Math.ceil(totalDatas/pageSize);
			
			return new SuccessDataResult<List<EmployeeListResponse>>(response);
		}





		@Override
		public Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type) {
			Pageable pageable=PageRequest.of(pageNo-1,pageSize,sortType(entity,type));


	        Map<String,Object> response=new HashMap<>();
	        Page<Employee> employees =employeeRepository.findAll(pageable);
	        response.put("totalElements",employees.getTotalElements()) ;
	        response.put("totalPages",employees.getTotalPages());
	        response.put("currentPage",employees.getNumber()+1);
	        response.put("customers",employees.getContent().stream().map(employee ->
	                this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList()));

	        return response ;
	    }


	 public Sort sortType(String property,String type){
	        if(type.equals("desc"))
	            return Sort.by(property).descending();
	        else return Sort.by(property).ascending() ;

	    }
	 
	 private void checkEmployeesReportsTo(Integer reportsTo) {
		 int count = 0;
	        for (Employee employee : this.employeeRepository.findAll()) {
	            if (employee.getReportsTo() == reportsTo) {
	                count++;
	            }
	        }
	        if (count > 10) {
	            throw new BusinessException("An employee can only take a look 10 person");
		}
	 
	 }
		



	

}
