package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Product;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	
	
	
	@Autowired
	public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
		
		this.categoryRepository = categoryRepository;
		this.modelMapperService = modelMapperService;
	}
	





	@Override
	public List<CategoryListResponse> getAll() {
		List<Category> result = this.categoryRepository.findAll();
		List<CategoryListResponse> response = result.stream().map(category->
		this.modelMapperService.forResponse().map(category, CategoryListResponse.class)).collect(
				Collectors.toList());		
		
		return response;
	}



	@Override
	public void add(CreateRequestCategory createRequestCategory) {
		
		Category category = this.modelMapperService.forRequest().
				map(createRequestCategory, Category.class);
		this.categoryRepository.save(category);
		
	}



	@Override
	public GetCategoryResponse getById(int categoryId) {
		
		Category category = this.categoryRepository.getById(categoryId);
		GetCategoryResponse getCategoryResponse = this.modelMapperService.forResponse().map(category, GetCategoryResponse.class);	
		return getCategoryResponse;
	}




	@Override
	public void update(UpdateRequestCategory updateRequestCategory) {
		Category category = this.modelMapperService.forResponse().map(updateRequestCategory, Category.class);
		this.categoryRepository.save(category);
	}






	@Override
	public void delete(DeleteRequestCategory deleteRequestCategory) {
		this.categoryRepository.deleteById(deleteRequestCategory.getCateogryId());
	}

}
