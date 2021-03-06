package com.gautam.service;

import java.util.List;

import com.gautam.model.User;

public interface UserService {
	
	public List<String> getAllUserId() throws Exception;
	
	public String addUser(User user) throws Exception;
	
	public String validateUser(String userId, String password) throws Exception;
	
	public User getUser(String userId) throws Exception;
	
	public String updateProfile(String userId, String firstName, String lastName, String profileImage) throws Exception;
	
	public String updatePassword(String userId, String password) throws Exception;
	
	public String deleteUser(String userId) throws Exception;
	
}
