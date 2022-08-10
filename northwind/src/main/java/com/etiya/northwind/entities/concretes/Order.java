package com.etiya.northwind.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "order_id")
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "required_date")
	private LocalDate requiredDate;

	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	

	
	@Column(name="freight")
	private double freight;
	
	@Column(name="ship_name")
	private String shipName;
	
	
	@Column(name="ship_address")
	private String shipAddress;
	
	@Column(name="ship_city")
	private String shipCity;
	
	@Column(name="ship_region")
	private String shipRegion;
	
	@Column(name="ship_postal_code")
	private String shipPostalCode;
	
	@Column(name="ship_country")
	private String shipCountry;
	


	



	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;

}