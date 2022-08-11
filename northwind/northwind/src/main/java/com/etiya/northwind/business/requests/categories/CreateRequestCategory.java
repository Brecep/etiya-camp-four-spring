package com.etiya.northwind.business.requests.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestCategory {
	
	private int categoryId;
	private String categoryName;
	private String description;
	private byte[] picture;
	

}
