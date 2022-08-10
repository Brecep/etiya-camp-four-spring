package com.etiya.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "picture")
	private byte[] picture;
	
	
	@OneToMany(mappedBy = "category") //eşleşeceği alana gider
	private List<Product> products; //bir kategorinin birden fazla ürünü olur
}