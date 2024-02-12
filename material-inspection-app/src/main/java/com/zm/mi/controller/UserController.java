package com.zm.mi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.User;
import com.zm.mi.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String userLogin(@RequestParam("userName") String userName, 
							@RequestParam("password") String password,
							HttpSession session,
							Model model) {
	
		User user =userService.getUserByuserNameAndPassword(userName,password);
		
		if(user!=null)
		{
			
			session.setAttribute("user",user);
			return ViewPageConstants.HOME_PAGE;
		}
		model.addAttribute("InvalidCredentials","Invalid credentials try again");
		return ViewPageConstants.LOGIN_PAGE;
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session)
	{
		session.setAttribute("user", null);
		
		return ViewPageConstants.LOGIN_PAGE;
	}

}
