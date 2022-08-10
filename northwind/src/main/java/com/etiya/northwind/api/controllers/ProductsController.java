package com.etiya.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;

	
	@Autowired
	public ProductsController(ProductService productService) {
		
		this.productService = productService;
	} 
	
	@GetMapping("/getAll")
	public List<ProductListResponse> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateRequestProduct createRequestProduct) {
		this.productService.add(createRequestProduct);
	}
	
	@GetMapping("/getById")
	public GetProductResponse getById(int productId){
		return this.productService.getById(productId);
		
		
	}
	
	@PostMapping("/update")
	public void update( UpdateRequestProduct updateRequestProduct) {
		this.productService.update(updateRequestProduct);
	}
	
	@PostMapping("/delete")
	public void delete( DeleteRequestProduct deleteRequestProduct) {
		this.productService.delete(deleteRequestProduct);
	}
	
	
}
