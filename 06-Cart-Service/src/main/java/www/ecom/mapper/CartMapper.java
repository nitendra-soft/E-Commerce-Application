package www.ecom.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import www.ecom.dto.CartDto;
import www.ecom.entity.Cart;
@Component
public class CartMapper {
	
	public static final ModelMapper mapper=new ModelMapper();
	
	public static CartDto convertToDto(Cart cart) {
		return mapper.map(cart, CartDto.class);
	}
	
	public static Cart convertToEntity(CartDto cartDto) {
		return mapper.map(cartDto, Cart.class);
	}

}
