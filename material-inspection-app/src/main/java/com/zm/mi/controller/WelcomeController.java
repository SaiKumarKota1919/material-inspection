package com.zm.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.mi.constants.ViewPageConstants;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome()
	{
		return ViewPageConstants.LOGIN_PAGE;
	}

}
