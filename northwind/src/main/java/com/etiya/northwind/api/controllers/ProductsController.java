package com.etiya.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;


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
	public void add(@Valid @RequestBody CreateRequestProduct createRequestProduct) {
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
	
//	@GetMapping("/{field}")
//    public ApiResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
//        List<Product> allProducts = productService.findProductsWithSort(field);
//        return new ApiResponse<>(allProducts.size(), allProducts);
//    }
//
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    public ApiResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Product> productsWithPagination = productService.findProductsWithPagination(offset, pageSize);
//        return new ApiResponse<>(productsWithPagination.getSize(),productsWithPagination);
//    }
//
//    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//    public ApiResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//        Page<Product> productsWithPagination = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
//        return new ApiResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }
	
    @GetMapping("/getAllPages")
	public List<ProductListResponse> getAllPages(int pageNo, int pageSize){
		return this.productService.getAllPages(pageNo , pageSize);
	}
	
	@GetMapping("/getAllPagesSort")
    public Map<String,Object> getAllPagesSort(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

        return this.productService.getAllPagesSort(pageNo,pageSize, entity,type.orElse(""));

    }
	
	
}
