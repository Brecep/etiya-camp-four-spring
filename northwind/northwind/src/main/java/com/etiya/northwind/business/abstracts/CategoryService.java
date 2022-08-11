package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;


import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

public interface CategoryService {

	DataResult<List<CategoryListResponse>> getAll();
	Result add(CreateRequestCategory createRequestCategory);
	DataResult<GetCategoryResponse> getById(int categoryId);
	Result update(UpdateRequestCategory updateRequestCategory);
	Result delete(DeleteRequestCategory deleteRequestCategory);
	
	DataResult<List<CategoryListResponse>> getAllPages(int pageNo , int pageSize);
	 Map<String,Object>getAllPagesSort(int pageNo, int pageSize,String entity,String type);
	
	 
//	
//	  List<Category> findCategoriesWithSorting(String field);
//	   Page<Category> findCategoriesWithPagination(int offset,int pageSize);
//	   Page<Category> findCategoriesWithPaginationAndSorting(int offset,int pageSize,String field);
	 
}
