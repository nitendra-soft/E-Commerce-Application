package www.ecom.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import www.ecom.dto.OrderDto;
import www.ecom.entity.Order;

@Component
public class OrderMapper {
	
	public static final ModelMapper mapper=new ModelMapper();
	
	public static OrderDto convertToDto(Order order) {
		return mapper.map(order, OrderDto.class);
	}
	
	public static Order convertToEntity(OrderDto orderDto) {
		return mapper.map(orderDto, Order.class);
	}

}
