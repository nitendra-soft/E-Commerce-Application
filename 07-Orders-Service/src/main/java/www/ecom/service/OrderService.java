package www.ecom.service;

import java.util.List;

import www.ecom.dto.ProductOrderDto;

public interface OrderService {
	
	public List<ProductOrderDto> addOrder(List<ProductOrderDto> productOrders);
	
	public ProductOrderDto updateOrder(ProductOrderDto productOrderDto);
	
	public List<ProductOrderDto> getOrdersByUserId(Integer userId);
	
	public List<ProductOrderDto> getOrdersByDateAndStatus(String orderDate, String orderStatus);
	
	public List<ProductOrderDto> getAllOrders();

}
