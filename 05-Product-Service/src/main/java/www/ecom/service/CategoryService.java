package www.ecom.service;

import java.util.List;

import www.ecom.dto.CategoryDto;

public interface CategoryService {
	
	public CategoryDto addCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto);
	
	public List<CategoryDto> getAllCategories();
	
	public CategoryDto getCategoryById(Integer categoryId);
	
	public CategoryDto deleteCategoryById(Integer categoryId);

}
