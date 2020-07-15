package com.gautam.dao;

import java.util.List;

import com.gautam.model.User;

public interface UserDAO {
	
	public List<String> getAllUserId() throws Exception;
	
	public String addUser(User user) throws Exception;
	
	public String getPassword(String userId) throws Exception;
	
	public User getUser(String userId) throws Exception;
	
	public String updateUserName(String userId, String firstName, String lastName) throws Exception;
	
	public String updatePassword(String userId, String password) throws Exception;
	
	public String deleteUser(String userId) throws Exception;
	
}
