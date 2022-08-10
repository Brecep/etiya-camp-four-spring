package com.etiya.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@Column(name="units_on_order")
	private int unitsOnOrder;
	
	@Column(name = "reorder_level")
	private int reorderLevel;
	
	@Column(name = "discontinued")
	private int discontinued;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
}
