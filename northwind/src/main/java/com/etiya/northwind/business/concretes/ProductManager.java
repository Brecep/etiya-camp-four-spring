package com.etiya.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
		this.productRepository = productRepository;
		this.modelMapperService = modelMapperService;
	}



	@Override
	public List<ProductListResponse> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> response = result.stream().map(product
				->this.modelMapperService.forResponse().
				map(product, ProductListResponse.class)).collect(Collectors.toList());
		
		return response;
	}

//update,delete,getById

	@Override
	public void add(CreateRequestProduct createRequestProduct ) {
		
		Product product = this.modelMapperService.forRequest().
				map(createRequestProduct, Product.class);
		this.productRepository.save(product);
		
	}



	@Override
	public GetProductResponse getById(int productId) {
		
		Product product = this.productRepository.getById(productId);
		GetProductResponse getProductResponse = this.modelMapperService.forResponse().map(product, GetProductResponse.class);	
		return getProductResponse;
		
		
	}



	@Override
	public void delete(DeleteRequestProduct deleteRequestProduct) {
			
		this.productRepository.deleteById(deleteRequestProduct.getProductId());
	}



	@Override
	public void update(UpdateRequestProduct updateRequestProduct) {
		
		Product product = this.modelMapperService.forRequest().map(updateRequestProduct, Product.class);
		this.productRepository.save(product);
		
	}

}















