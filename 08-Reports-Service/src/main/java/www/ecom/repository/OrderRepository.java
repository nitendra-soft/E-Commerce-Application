package www.ecom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import www.ecom.entity.Order;
import www.ecom.entity.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query("select o from Order o where o.status=:status")
	List<Order> findByStatus(OrderStatus status);
	
	@Query("select o from Order o where o.orderDate Between :startDate And :endDate")
	List<Order> findOrderBetweenDates(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);

}
