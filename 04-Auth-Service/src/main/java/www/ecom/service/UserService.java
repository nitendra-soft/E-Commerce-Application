package www.ecom.service;

import www.ecom.entity.User;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


public interface UserService{
	
	public User addUser(User user, MultipartFile file) throws Exception;
	
	public User login(User user);
	
	public User getUserById(Integer userId);
	
	public List<User> getAllUsers();
	
	public User deleteUserById(Integer userId);

}
