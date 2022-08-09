package com.etiya.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.dataAccess.absracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryListResponse> getAll() {
		List<Category> categories = this.categoryRepository.findAll();
		List<CategoryListResponse> categoryListResponses = new ArrayList<>();
		for (Category category : categories) {
			CategoryListResponse categoryListResponse = new CategoryListResponse();
			categoryListResponse.setCategoryId(category.getCategoryId());
			categoryListResponse.setCategoryName(category.getCategoryName());

			categoryListResponses.add(categoryListResponse);
		}
		return categoryListResponses;
	}

}
