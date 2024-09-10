package www.ecom.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.ecom.dto.OrderDto;
import www.ecom.entity.Order;
import www.ecom.entity.OrderStatus;
import www.ecom.mapper.OrderMapper;
import www.ecom.repository.OrderRepository;

@Service
public class ReportsServiceImpl implements ReportsService {
	@Autowired
	private OrderRepository orderRepo;
	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<OrderDto> orderByStatus(OrderStatus status) {
		List<Order> byStatus = orderRepo.findByStatus(status);
		return byStatus.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<OrderDto> getOrdersBetweenDate(LocalDate startDate, LocalDate endDate) {
		List<Order> dates = orderRepo.findOrderBetweenDates(startDate, endDate);
		return dates.stream().map(OrderMapper::convertToDto).collect(Collectors.toList());
	}

}
