package www.ecom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import www.ecom.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
	
	public List<Orders> findByUserId(Integer userId);
	public List<Orders> findByOrderDateAndOrderStatus(String orderDate, String orderStatus);

}
