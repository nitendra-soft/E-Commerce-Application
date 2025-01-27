package www.ecom.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import www.ecom.entity.User;
import www.ecom.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User u = userRepo.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPwd(),
				Collections.emptyList());
	}

}
