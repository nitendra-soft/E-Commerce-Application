package www.ecom.mapper;

import org.modelmapper.ModelMapper;

import www.ecom.dto.CartDto;
import www.ecom.entity.Cart;

public class CartMapper {
	
	public static CartDto convertToDto(Cart cart) {
		ModelMapper mapper=new ModelMapper();
		return mapper.map(cart, CartDto.class);
	}
	
	public static Cart convertToEntity(CartDto cartDto) {
		ModelMapper mapper=new ModelMapper();
		return mapper.map(cartDto, Cart.class);
	}

}
