package com.zm.mi.service;

import com.zm.mi.entity.User;

public interface UserService {

	boolean isValidUser(User user);
	
	User getUserById(Integer userId);

	User getUserByuserNameAndPassword(String userName,String password);

}
