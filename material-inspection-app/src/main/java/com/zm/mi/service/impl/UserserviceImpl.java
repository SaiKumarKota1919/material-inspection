package com.zm.mi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.mi.entity.User;
import com.zm.mi.repo.UserRepo;
import com.zm.mi.service.UserService;
@Service
public class UserserviceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean isValidUser(User user) {
		if (userRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword()).isEmpty())
		{
			
			return false;

		}

		return true;
	}

	@Override
	public User getUserById(Integer userId) {
		
		Optional<User> user = userRepo.findById(userId);
		
		if(user.isPresent())
		{
			return user.get();
		}
		
		return null;
	}

	@Override
	public User getUserByuserNameAndPassword(String userName,String password) {
		Optional<User> user = userRepo.findByUserNameAndPassword(userName,password);
		
		if (user.isPresent())
		{
			
			return user.get();

		}

		return null;

	}

}
