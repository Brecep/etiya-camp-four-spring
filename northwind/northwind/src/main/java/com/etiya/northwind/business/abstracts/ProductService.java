package com.etiya.northwind.business.abstracts;
import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.products.CreateRequestProduct;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.requests.products.UpdateRequestProduct;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;


public interface ProductService {

	DataResult<List<ProductListResponse>>  getAll();
	Result add(CreateRequestProduct createRequestProduct) ;
	DataResult<GetProductResponse> getById(int productId);
	Result delete(DeleteRequestProduct deleteRequestProduct);
	Result update(UpdateRequestProduct updateRequestProduct);
//	List<Product> findProductsWithSort(String field);
//    Page<Product> findProductsWithPagination(int offset, int pageSize);
//    Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field);
    
    DataResult<List<ProductListResponse>> getAllPages(int pageNo , int pageSize);
    Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	 
	 
}
