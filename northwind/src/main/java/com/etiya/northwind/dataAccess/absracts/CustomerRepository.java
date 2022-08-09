package com.etiya.northwind.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
