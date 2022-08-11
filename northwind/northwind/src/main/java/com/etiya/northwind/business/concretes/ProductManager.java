package com.etiya.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
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
	public DataResult<List<ProductListResponse>> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> response = result.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ProductListResponse>>(response);

	}

	@Override
	public Result add(CreateRequestProduct createRequestProduct) {

		checkIfCategoryLimitExceeds(createRequestProduct.getCategoryId());
		checkProductNameExists(createRequestProduct.getProductName());
		Product product = this.modelMapperService.forRequest().map(createRequestProduct, Product.class);
		this.productRepository.save(product);
		return new SuccessResult("Product added");

	}

	@Override
	public DataResult<GetProductResponse> getById(int productId) {

		Product product = this.productRepository.getById(productId);
		GetProductResponse getProductResponse = this.modelMapperService.forResponse().map(product,
				GetProductResponse.class);
		return new SuccessDataResult<GetProductResponse>(getProductResponse);

	}

	@Override
	public Result delete(DeleteRequestProduct deleteRequestProduct) {

		this.productRepository.deleteById(deleteRequestProduct.getProductId());
		return new SuccessResult("Product deleted");
	}

	@Override
	public Result update(UpdateRequestProduct updateRequestProduct) {

		Product product = this.modelMapperService.forRequest().map(updateRequestProduct, Product.class);
		this.productRepository.save(product);
		return new SuccessResult("Product updated");

	}

	@Override
	public DataResult<List<ProductListResponse>> getAllPages(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Product> products = this.productRepository.findAll(pageable).getContent();
		List<ProductListResponse> response = products.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
				.collect(Collectors.toList());

		int currentPage = pageNo;
		int totalDatas = products.size();
		int totalPages = (int) Math.ceil(totalDatas / pageSize);

		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	@Override
	public Map<String, Object> getAllPagesSort(int pageNo, int pageSize, String entity, String type) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sortType(entity, type));

		Map<String, Object> response = new HashMap<>();
		Page<Product> products = productRepository.findAll(pageable);
		response.put("totalElements", products.getTotalElements());
		response.put("totalPages", products.getTotalPages());
		response.put("currentPage", products.getNumber() + 1);
		response.put("customers",
				products.getContent().stream()
						.map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
						.collect(Collectors.toList()));

		return response;
	}

	public Sort sortType(String property, String type) {
		if (type.equals("desc"))
			return Sort.by(property).descending();
		else
			return Sort.by(property).ascending();

	}

	private void checkIfCategoryLimitExceeds(int categoryId) {
		int count = 0;
        for (Product product : this.productRepository.findAll()) {
            if (product.getCategory().getCategoryId() == categoryId) {
                count++;
            }
        }
        if (count > 15)
            throw new BusinessException("The number of categories is greater than 15");
	}
	
	private void checkProductNameExists(String productName) {

		for(Product product : this.productRepository.findAll()) {
			if(product.getProductName().equals(productName)) {
				throw new BusinessException("Product name exists");
			}
			
		}
		
	}
	
	
	

//
//	@Override
//	public List<Product> findProductsWithSort(String field) {
//		 return  productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
//
//	}
//
//
//
//	@Override
//	public Page<Product> findProductsWithPagination(int offset, int pageSize) {
//	    Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
//        return  products;
//	}
//
//
//
//	@Override
//	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
//		Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return  products;
//	}

}
