package com.sample.mogo.dao;

import java.util.List;

import com.sample.mogo.domain.User;

public interface UserDao {
	
	public List<User> getUser();
	
	public User getUserById(String lastname);
	
	public String addUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);

}
