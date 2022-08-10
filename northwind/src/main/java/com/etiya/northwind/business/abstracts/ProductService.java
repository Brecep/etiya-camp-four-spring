package com.etiya.northwind.business.abstracts;
import java.util.List;

import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;


public interface ProductService {

	List<ProductListResponse> getAll();
	void add(CreateRequestProduct createRequestProduct);
	GetProductResponse getById(int productId);
	void delete(DeleteRequestProduct deleteRequestProduct);
	void update(UpdateRequestProduct updateRequestProduct);
}
