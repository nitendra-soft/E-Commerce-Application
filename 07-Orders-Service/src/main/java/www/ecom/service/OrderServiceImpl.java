package www.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.ecom.dto.ProductOrderDto;
import www.ecom.entity.Orders;
import www.ecom.mapper.OrderMapper;
import www.ecom.repo.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrdersRepository orderRepo;
	
	@Override
	public List<ProductOrderDto> addOrder(List<ProductOrderDto> productOrders) {
		List<Orders> orderEntities = productOrders.stream().map(OrderMapper::convertToEntity)
		.collect(Collectors.toList());
		List<Orders> orders = orderRepo.saveAll(orderEntities);
		return orders.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
	}
	
	@Override
	public ProductOrderDto updateOrder(ProductOrderDto productOrderDto) {
		Orders orderEntity = OrderMapper.convertToEntity(productOrderDto);
		Orders order = orderRepo.findById(orderEntity.getOrderId()).orElseThrow();
		if(order !=null) {
			order.setProductId(productOrderDto.getProductId());
			order.setPrice(productOrderDto.getPrice());
			order.setQuantity(productOrderDto.getQuantity());
			order.setPaymentType(productOrderDto.getPaymentType());
			order.setOrderDate(productOrderDto.getOrderDate());
			order.setOrderStatus(productOrderDto.getOrderStatus());
			Orders updatedOrder = orderRepo.save(order);
			return OrderMapper.convertToDto(updatedOrder);
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<ProductOrderDto> getOrdersByUserId(Integer userId) {
		List<Orders> orders = orderRepo.findByUserId(userId);
		if(orders !=null && !orders.isEmpty()) {
			return orders.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
		}else {
			return null;
		}
	}
	
	@Override
	public List<ProductOrderDto> getOrdersByDateAndStatus(String orderDate, String orderStatus) {
		List<Orders> orders = orderRepo.findByOrderDateAndOrderStatus(orderDate, orderStatus);
		if(orders !=null) {
			return orders.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
		}else {
			return null;
		}
	}
	
	@Override
	public List<ProductOrderDto> getAllOrders() {
		List<Orders> orders = orderRepo.findAll();
		return orders.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
	}

}
