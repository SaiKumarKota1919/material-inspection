package com.zm.mi.service.impl;

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

}
