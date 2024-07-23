package www.ecom.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import www.ecom.constants.AppConstants;
import www.ecom.entity.User;
import www.ecom.props.AppProperties;
import www.ecom.response.ApiResponse;
import www.ecom.service.UserService;

@RestController
public class UserRestController {
	
	private static Logger log=LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private AppProperties props;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<User>> createUser(@RequestParam("user") String userJson, @RequestParam("file") MultipartFile file) 
			throws Exception {
		
		log.info("User Registration Process Started");
		
		ApiResponse<User> response=new ApiResponse<>();
		Map<String,String> messages = props.getMessages();
		
		ObjectMapper mapper=new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);
		User addedUser = userService.addUser(user, file);
		
		if(addedUser != null) {
			response.setStatus(201);
			response.setMessage(messages.get(AppConstants.User_Reg));
			response.setData(addedUser);
		}else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.User_Reg_Err));
		}
		log.info("User Registration Process Completed");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<User>> login(@RequestBody User user){
		
		log.info("User Login Process Started");
		
		ApiResponse<User> response=new ApiResponse<>();
		Map<String,String> messages = props.getMessages();
		
		User loggedInUser = userService.login(user);
		
		if(loggedInUser != null) {
			response.setStatus(200);
			response.setMessage(messages.get(AppConstants.Login));
			response.setData(loggedInUser);
		}else {
			log.error("User Login Failed");
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.Login_Err));
		}
		log.info("User Login Process Completed");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
