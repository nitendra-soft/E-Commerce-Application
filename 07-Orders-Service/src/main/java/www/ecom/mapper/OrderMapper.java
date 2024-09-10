package www.ecom.mapper;

import org.modelmapper.ModelMapper;

import www.ecom.dto.ProductOrderDto;
import www.ecom.entity.Orders;

public class OrderMapper {
	
	public static final ModelMapper mapper=new ModelMapper();
	
	public static ProductOrderDto convertToDto(Orders order) {
	return mapper.map(order, ProductOrderDto.class);
	}
	
	public static Orders convertToEntity(ProductOrderDto productOrderDto) {
		return mapper.map(productOrderDto, Orders.class);
	}
}
