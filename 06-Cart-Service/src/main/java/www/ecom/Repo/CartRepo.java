package www.ecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import www.ecom.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
