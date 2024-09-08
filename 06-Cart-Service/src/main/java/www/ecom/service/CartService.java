package www.ecom.service;

import www.ecom.dto.CartDto;

public interface CartService {
	
	public CartDto addToCart(CartDto cartDto);
	
	public CartDto updateCartQuantityById(CartDto cartDto);
	
	public CartDto getCartByUserId(Integer userId);
	
	public CartDto deleteCartById(Integer cartId);

}
