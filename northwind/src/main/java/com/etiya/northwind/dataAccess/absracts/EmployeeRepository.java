package com.etiya.northwind.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
