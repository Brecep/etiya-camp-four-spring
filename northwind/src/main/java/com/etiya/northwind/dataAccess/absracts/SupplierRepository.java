package com.etiya.northwind.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
