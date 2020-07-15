package com.gautam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gautam.entity.UserEntity;
import com.gautam.model.User;

@Repository(value="userDAO")
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<String> getAllUserId() throws Exception {
		String queryString ="select u.userId from UserEntity u";
		Query query=entityManager.createQuery(queryString);
		List<String> listOfUserId = query.getResultList();
		return listOfUserId;
	}
	
	@Override
	public String addUser(User user) throws Exception {
		UserEntity userEntity=entityManager.find(UserEntity.class, user.getUserId());
		String userId=null;
		if(userEntity==null) {
			userEntity=new UserEntity();
			userEntity.setUserId(user.getUserId());
			userEntity.setPassword(user.getPassword());
			userEntity.setFirstName(user.getFirstName());
			userEntity.setLastName(user.getLastName());
			entityManager.persist(userEntity);
			userId=userEntity.getUserId();
		}
		return userId;
	}
	
	@Override
	public String getPassword(String userId) throws Exception {
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		String password=null;
		if(userEntity!=null) {
			password=userEntity.getPassword();
		}
		return password;
	}
	
	@Override
	public User getUser(String userId) throws Exception {
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		User user=null;
		if(userEntity!=null) {
			user=new User();
			user.setUserId(userEntity.getUserId());
			user.setFirstName(userEntity.getFirstName());
			user.setLastName(userEntity.getLastName());
		}
		return user;
	}
	
	@Override
	public String updateUserName(String userId, String firstName, String lastName) throws Exception {
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		String id=null;
		if(userEntity!=null) {
			userEntity.setFirstName(firstName);
			userEntity.setLastName(lastName);
			id=userEntity.getUserId();
		}
		return id;
	}
	
	@Override
	public String updatePassword(String userId, String password) throws Exception {
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		String id=null;
		if(userEntity!=null) {
			userEntity.setPassword(password);
			id=userEntity.getUserId();
		}
		return id;
	}
	
	@Override
	public String deleteUser(String userId) throws Exception {
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		String id=null;
		if(userEntity!=null) {
			entityManager.remove(userEntity);
			id=userEntity.getUserId();
		}
		return id;
	}

}
