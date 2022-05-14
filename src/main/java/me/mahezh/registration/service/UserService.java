package me.mahezh.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import me.mahezh.registration.model.User;
import me.mahezh.registration.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	
}
