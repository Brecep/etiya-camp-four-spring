package com.etiya.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailsPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailsPK> {

	//OrderDetail getById(int orderId, int productId);

	//void deleteByOrderIdAndProductId(int orderId, int productId);
	
}


//orderdetail,customer(id bölümü string sorunu)
//order ve supplier yapılacak
//sayfalama yapılacak