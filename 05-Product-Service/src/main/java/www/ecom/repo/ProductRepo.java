package www.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import www.ecom.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
