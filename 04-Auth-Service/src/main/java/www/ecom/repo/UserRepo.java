package www.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import www.ecom.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email); 

}
