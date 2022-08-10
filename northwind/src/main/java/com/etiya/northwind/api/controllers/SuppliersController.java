package com.etiya.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.requests.suppliers.CreateRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.DeleteRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.UpdateRequestSupplier;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;

import java.util.List;


@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
	
	private SupplierService supplierService;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
	
		this.supplierService = supplierService;
	}
	
	@GetMapping("/getAll")
	public List<SupplierListResponse> getAll(){
		return this.supplierService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateRequestSupplier createRequestSupplier) {
		this.supplierService.add(createRequestSupplier);
	}
	
	@GetMapping("/getById")
	public GetSupplierResponse getById(int supplierId){
		return this.supplierService.getById(supplierId);
		
		
	}
	
	@PostMapping("/update")
	public void update( UpdateRequestSupplier updateRequestSupplier) {
		this.supplierService.update(updateRequestSupplier);
	}
	
	@PostMapping("/delete")
	public void delete( DeleteRequestSupplier deleteRequestSupplier) {
		this.supplierService.delete(deleteRequestSupplier);
	}
	
	
	
	

}
