package www.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import www.ecom.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
