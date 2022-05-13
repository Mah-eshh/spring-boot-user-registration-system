package me.mahezh.registration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.mahezh.registration.service.UserService;

@Controller
@RequestMapping("/registration")

public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
}
