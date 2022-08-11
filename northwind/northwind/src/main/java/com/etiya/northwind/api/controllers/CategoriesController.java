package com.etiya.northwind.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateRequestCategory;
import com.etiya.northwind.business.requests.categories.DeleteRequestCategory;
import com.etiya.northwind.business.requests.categories.UpdateRequestCategory;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {

		this.categoryService = categoryService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CategoryListResponse>> getAll() {
		return this.categoryService.getAll();
	}

	@GetMapping("/getAllPages")
	public DataResult<List<CategoryListResponse>> getAllPages(int pageNo, int pageSize) {
		return this.categoryService.getAllPages(pageNo, pageSize);
	}

	@GetMapping("/getAllPagesSort")
	public Map<String, Object> getAllPagesSort(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestParam String entity, @RequestParam Optional<String> type) {

		return this.categoryService.getAllPagesSort(pageNo, pageSize, entity, type.orElse(""));

	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateRequestCategory createRequestCategory) {
		return this.categoryService.add(createRequestCategory);
	}

	@GetMapping("/getById")
	public DataResult<GetCategoryResponse> getById(int categoryId) {
		return this.categoryService.getById(categoryId);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateRequestCategory updateRequestCategory) {
		return this.categoryService.update(updateRequestCategory);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteRequestCategory deleteRequestCategory) {
		return this.categoryService.delete(deleteRequestCategory);
	}

//	@GetMapping("/{field}")
//    public ApiResponse<List<Category>> getCategoriesWithSort(@PathVariable String field) {
//        List<Category> allCategories = categoryService.findCategoriesWithSorting(field);
//        return new ApiResponse<>(allCategories.size(), allCategories);
//    }
//
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    public ApiResponse<Page<Category>> getCategoriesWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Category> categoriesWithPagination = categoryService.findCategoriesWithPagination(offset, pageSize);
//        return new ApiResponse<>(categoriesWithPagination.getSize(),categoriesWithPagination);
//    }
//
//    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//    public ApiResponse<Page<Category>> getCategoriesWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//        Page<Category> categoriesWithPagination = categoryService.findCategoriesWithPaginationAndSorting(offset, pageSize, field);
//        return new ApiResponse<>(categoriesWithPagination.getSize(), categoriesWithPagination);
//    }

}
