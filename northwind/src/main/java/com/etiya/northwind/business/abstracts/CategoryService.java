package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;

public interface CategoryService {

	List<CategoryListResponse> getAll();
	void add(CreateRequestCategory createRequestCategory);
	GetCategoryResponse getById(int categoryId);
	void update(UpdateRequestCategory updateRequestCategory);
	void delete(DeleteRequestCategory deleteRequestCategory);
	
	List<CategoryListResponse> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
	 
//	
//	  List<Category> findCategoriesWithSorting(String field);
//	   Page<Category> findCategoriesWithPagination(int offset,int pageSize);
//	   Page<Category> findCategoriesWithPaginationAndSorting(int offset,int pageSize,String field);
	 
}
