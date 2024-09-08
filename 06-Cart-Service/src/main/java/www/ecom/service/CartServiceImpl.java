package www.ecom.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.ecom.Repo.CartRepo;
import www.ecom.dto.CartDto;
import www.ecom.entity.Cart;
import www.ecom.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService  {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public CartDto addToCart(CartDto cartDto) {
		Cart cart = CartMapper.convertToEntity(cartDto);
		Cart savedCart = cartRepo.save(cart);
		return CartMapper.convertToDto(savedCart);
	}
	
	@Override
	public CartDto updateCartQuantityById(CartDto cartDto) {
		Optional<Cart> cartById = cartRepo.findById(cartDto.getCartId());
		if(cartById.isPresent()) {
			Cart cart = cartById.get();
			cart.setProductId(cartDto.getProductId());
			cart.setQuantity(cartDto.getQuantity());
			Cart updatedCart = cartRepo.save(cart);
			return CartMapper.convertToDto(updatedCart);
		}else {
			throw new NoSuchElementException("Cart not found for ID : "+ cartDto.getCartId());
		}
	}
	
	@Override
	public CartDto getCartByUserId(Integer userId) {
		Cart cart = cartRepo.findById(userId).orElseThrow();
		CartDto cartDto = CartMapper.convertToDto(cart);
		return cartDto;
	}
	
	@Override
	public CartDto deleteCartById(Integer cartId) {
		Cart cart = cartRepo.findById(cartId).orElseThrow();
		CartDto cartDto = CartMapper.convertToDto(cart);
		cartRepo.deleteById(cartId);
		return cartDto;
	}

}
