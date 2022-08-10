package com.etiya.northwind.business.abstracts;

import java.util.List;

import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.requests.products.DeleteRequestProduct;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;

public interface CategoryService {

	List<CategoryListResponse> getAll();
	void add(CreateRequestCategory createRequestCategory);
	GetCategoryResponse getById(int categoryId);
	void update(UpdateRequestCategory updateRequestCategory);
	void delete(DeleteRequestCategory deleteRequestCategory);
}
