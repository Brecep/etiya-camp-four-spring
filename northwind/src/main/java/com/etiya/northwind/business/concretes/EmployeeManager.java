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
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;

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
		public List<EmployeeListResponse> getAllPages(int pageNo, int pageSize) {
			
			Pageable pageable = PageRequest.of(pageNo-1, pageSize);
			List<Employee> employees = this.employeeRepository.findAll(pageable).getContent();
			List<EmployeeListResponse> response = employees.stream().map(employee->
			this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class)).collect(
					Collectors.toList());
			
			int currentPage = pageNo;
			int totalDatas = employees.size();
			int totalPages = (int) Math.ceil(totalDatas/pageSize);
			
			return response;
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
		



	

}
