package com.zm.mi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.User;
import com.zm.mi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String userLogin(@RequestParam("userName") String userName, 
							@RequestParam("password") String password) {
	
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		if(userService.isValidUser(user))
		{
			System.out.println("#######################");
			return ViewPageConstants.HOME_PAGE;
		}
		return ViewPageConstants.LOGIN_PAGE;
	}

}
