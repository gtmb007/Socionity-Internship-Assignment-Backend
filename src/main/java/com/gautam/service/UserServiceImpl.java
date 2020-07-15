package com.gautam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gautam.dao.UserDAO;
import com.gautam.model.User;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<String> getAllUserId() throws Exception {
		List<String> listOfUserId=userDAO.getAllUserId();
		if(listOfUserId==null || listOfUserId.isEmpty()) throw new Exception("Service.NO_USERS_FOUND");
		return listOfUserId;
	}
	
	@Override
	public String addUser(User user) throws Exception {
		String userId=userDAO.addUser(user);
		if(userId==null) throw new Exception("Service.USER_SIGNUP_FAILED");
		return userId;
	}
	
	@Override
	public String validateUser(String userId, String password) throws Exception {
		String pwd=userDAO.getPassword(userId);
		if(pwd==null || !pwd.equals(password)) throw new Exception("Service.USER_LOGIN_FAILED");
		return userId;
	}
	
	@Override
	public User getUser(String userId) throws Exception {
		User user=userDAO.getUser(userId);
		if(user==null) throw new Exception("Service.USER_NOT_FOUND");
		return user;
	}
	
	@Override
	public String updateUserName(String userId, String firstName, String lastName) throws Exception {
		String id=userDAO.updateUserName(userId, firstName, lastName);
		if(id==null) throw new Exception("Service.USERNAME_UPDATION_FAILED");
		return id;
	}
	
	@Override
	public String updatePassword(String userId, String password) throws Exception {
		String id=userDAO.updatePassword(userId, password);
		if(id==null) throw new Exception("Service.USERPASSWORD_UPDATION_FAILED");
		return id;
	}
	
	@Override
	public String deleteUser(String userId) throws Exception {
		String id=userDAO.deleteUser(userId);
		if(id==null) throw new Exception("Service.USER_DELETION_FAILED");
		return id;
	}
}
