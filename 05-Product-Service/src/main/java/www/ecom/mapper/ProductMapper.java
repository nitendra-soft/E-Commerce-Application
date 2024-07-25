package www.ecom.mapper;

import org.modelmapper.ModelMapper;

import www.ecom.dto.ProductDto;
import www.ecom.entity.Product;

public class ProductMapper {
	
	private static final ModelMapper mapper=new ModelMapper();
	
	public static ProductDto convertToDto(Product product) {
		return mapper.map(product, ProductDto.class);
	}
	
	public static Product convertToEntity(ProductDto productDto) {
		return mapper.map(productDto, Product.class);
	}

}
