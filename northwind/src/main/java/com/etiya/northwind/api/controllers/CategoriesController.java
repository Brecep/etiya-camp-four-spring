package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.products.GetProductResponse;



@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	
	private CategoryService categoryService;

	
	@Autowired
	public CategoriesController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	} 
	
	@GetMapping("/getAll")
	public List<CategoryListResponse> getAll(){
		return this.categoryService.getAll();
	}
	

	@PostMapping("/add")
	public void add(@RequestBody CreateRequestCategory createRequestCategory) {
		this.categoryService.add(createRequestCategory);
	}
	
	@GetMapping("/getById")
	public GetCategoryResponse getById(int categoryId){
		return this.categoryService.getById(categoryId);
		
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateRequestCategory updateRequestCategory) {
		this.categoryService.update(updateRequestCategory);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteRequestCategory deleteRequestCategory) {
		this.categoryService.delete(deleteRequestCategory);
	}
	

}
