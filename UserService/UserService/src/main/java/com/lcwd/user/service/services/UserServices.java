package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserServices {

	//save single user
	User saveUser(User user);
	
	//get single user
	User getSingleUser(String userId);
	
	//get all user
	List<User> getAllUser();
	
	//update user
	User updateUser(User user);
	
	//Delete user
	void deleteUser(String userId);
	
}
