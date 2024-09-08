package www.ecom.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import www.ecom.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {
	
	Optional<Cart> findByUserId(Integer userId);

}
