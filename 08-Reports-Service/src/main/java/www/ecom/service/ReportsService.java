package www.ecom.service;

import java.time.LocalDate;
import java.util.List;

import www.ecom.dto.OrderDto;
import www.ecom.entity.OrderStatus;

public interface ReportsService {
	
	public List<OrderDto> getAllOrders();
	
	public List<OrderDto> orderByStatus(OrderStatus status);
	
	public List<OrderDto> getOrdersBetweenDate(LocalDate startDate, LocalDate endDate);

}
