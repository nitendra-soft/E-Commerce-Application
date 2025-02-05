package www.ecom.service;

import java.util.List;

import www.ecom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import www.ecom.repo.UserRepo;
import www.ecom.utils.FileUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder pwdEncoder;
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public User addUser(User user, MultipartFile file) throws Exception {
		
		User exitingUser = userRepo.findByEmail(user.getEmail());
		
		if(exitingUser == null) {
			String fileName = FileUtils.saveFile(file.getName(), file);
			String encodedPwd = pwdEncoder.encode(user.getPwd());
			user.setPwd(encodedPwd);
			user.setUserpic(fileName);;
			return userRepo.save(user);
		}
		return exitingUser;
	}

	@Override
	public User login(User user) {
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPwd());
		Authentication authenticate=null;
		try {
		 authenticate = authManager.authenticate(token);
		if(authenticate.isAuthenticated()) {
			return userRepo.findByEmail(user.getEmail());
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepo.findById(userId).orElseThrow();
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User deleteUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow();
		if(user != null) {
			userRepo.deleteById(userId);
			return user;
		}else {
			return null;
		}
	}

}
