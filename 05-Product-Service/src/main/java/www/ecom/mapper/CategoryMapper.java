package www.ecom.mapper;

import org.modelmapper.ModelMapper;

import www.ecom.dto.CategoryDto;
import www.ecom.entity.Category;

public class CategoryMapper {
	
	private static final ModelMapper mapper=new ModelMapper();
	
	public static CategoryDto convertToDto(Category category) {
		return mapper.map(category, CategoryDto.class);
	}
	
	public static Category convertToEntity(CategoryDto categoryDto) {
		return mapper.map(categoryDto, Category.class);
	}

}
