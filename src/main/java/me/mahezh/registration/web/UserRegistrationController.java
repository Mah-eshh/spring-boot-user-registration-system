package me.mahezh.registration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.mahezh.registration.service.UserService;
import me.mahezh.registration.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")

public class UserRegistrationController {
	
	
	//Inject userService
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//Thymeleaf get user registration details here
	@ModelAttribute("user")
	public UserRegistrationDto userregistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	//method handler
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect/registration?success";
	}
	

}
