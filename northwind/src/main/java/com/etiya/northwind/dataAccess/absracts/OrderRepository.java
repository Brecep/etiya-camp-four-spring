package com.etiya.northwind.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
