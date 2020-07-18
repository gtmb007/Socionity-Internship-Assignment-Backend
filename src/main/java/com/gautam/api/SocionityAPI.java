package com.gautam.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gautam.model.User;
import com.gautam.service.UserService;

@RestController
@RequestMapping(value="/socionity")
@CrossOrigin(origins = "http://localhost:3000")
public class SocionityAPI {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value="/users")
	public ResponseEntity<List<String>> getAllUserId() throws Exception {
		try {
			List<String> listOfUserId=userService.getAllUserId();
			ResponseEntity<List<String>> response=new ResponseEntity<List<String>>(listOfUserId, HttpStatus.OK);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
	}
	
	@PostMapping(value="/user")
	public ResponseEntity<String> userSignup(@RequestBody User user) throws Exception {
		try {
			String userId=userService.addUser(user);
			String message=environment.getProperty("API.USER_SIGNUP_SUCCESS")+userId;
			ResponseEntity<String> response=new ResponseEntity<String>(message, HttpStatus.CREATED);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
		}
	} 
	
	@GetMapping(value="/user/{id}/{password}")
	public ResponseEntity<String> userLogin(@PathVariable String id, @PathVariable String password) throws Exception {
		try {
			String userId=userService.validateUser(id, password);
			String message=environment.getProperty("API.USER_LOGIN_SUCCESS")+userId;
			ResponseEntity<String> response=new ResponseEntity<String>(message, HttpStatus.OK);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
	}
	
	@GetMapping(value="/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) throws Exception {
		try {
			User user=userService.getUser(id);
			ResponseEntity<User> response=new ResponseEntity<User>(user, HttpStatus.OK);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
	}
	
	@PutMapping(value="/user/profile/{id}")
	public ResponseEntity<String> updateProfile(@PathVariable String id, @RequestBody User user) throws Exception {
		try {
			String userId=userService.updateProfile(id, user.getFirstName(), user.getLastName(), user.getProfileImage());
			String message=environment.getProperty("API.USER_NAME_UPDATED")+userId;
			ResponseEntity<String> response=new ResponseEntity<String>(message, HttpStatus.CREATED);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
		}
	}
	
	@PutMapping(value="/user/password/{id}")
	public ResponseEntity<String> updatePassword(@PathVariable String id, @RequestBody User user) throws Exception {
		try {
			String userId=userService.updatePassword(id, user.getPassword());
			String message=environment.getProperty("API.USER_PASSWORD_UPDATED")+userId;
			ResponseEntity<String> response=new ResponseEntity<String>(message, HttpStatus.CREATED);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
		}
	}
	
	
	@DeleteMapping(value="/user/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable String id) throws Exception {
		try {
			String userId=userService.deleteUser(id);
			String message=environment.getProperty("API.ACCOUNT_DELETED")+userId;
			ResponseEntity<String> response=new ResponseEntity<String>(message, HttpStatus.CREATED);
			return response;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
		}
	}

}
