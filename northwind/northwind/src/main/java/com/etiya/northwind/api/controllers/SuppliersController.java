package com.etiya.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.SupplierService;

import com.etiya.northwind.business.requests.suppliers.CreateRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.DeleteRequestSupplier;
import com.etiya.northwind.business.requests.suppliers.UpdateRequestSupplier;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
	
	private SupplierService supplierService;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
	
		this.supplierService = supplierService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SupplierListResponse>> getAll(){
		return this.supplierService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateRequestSupplier createRequestSupplier) {
		return this.supplierService.add(createRequestSupplier);
	}
	
	@GetMapping("/getById")
	public DataResult<GetSupplierResponse> getById(int supplierId){
		return this.supplierService.getById(supplierId);
		
		
	}
	
	@PostMapping("/update")
	public Result update( UpdateRequestSupplier updateRequestSupplier) {
		return this.supplierService.update(updateRequestSupplier);
	}
	
	@PostMapping("/delete")
	public Result delete( DeleteRequestSupplier deleteRequestSupplier) {
		return this.supplierService.delete(deleteRequestSupplier);
	}
	
//	@GetMapping("/{field}")
//    public ApiResponse<List<Supplier>> getSuppliersWithSort(@PathVariable String field) {
//        List<Supplier> allSuppliers = supplierService.findSuppliersWithSort(field);
//        return new ApiResponse<>(allSuppliers.size(), allSuppliers);
//    }
//
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    public ApiResponse<Page<Supplier>> getSuppliersWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Supplier> suppliersWithPagination = supplierService.findSuppliersWithPagination(offset, pageSize);
//        return new ApiResponse<>(suppliersWithPagination.getSize(),suppliersWithPagination);
//    }
//
//    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//    public ApiResponse<Page<Supplier>> getSuppliersWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//        Page<Supplier> suppliersWithPagination = supplierService.findSuppliersWithPaginationAndSorting(offset, pageSize, field);
//        return new ApiResponse<>(suppliersWithPagination.getSize(), suppliersWithPagination);
//    }
	
	 @GetMapping("/getAllPages")
		public DataResult<List<SupplierListResponse>> getAllPages(int pageNo, int pageSize){
			return this.supplierService.getAllPages(pageNo , pageSize);
		}
		
		@GetMapping("/getAllPagesSort")
	    public Map<String,Object> getAllPagesSort(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

	        return this.supplierService.getAllPagesSort(pageNo,pageSize, entity,type.orElse(""));

	    }
		
	
	
	

}
