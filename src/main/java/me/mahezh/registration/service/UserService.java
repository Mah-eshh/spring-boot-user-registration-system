package me.mahezh.registration.service;

import me.mahezh.registration.model.User;
import me.mahezh.registration.web.dto.UserRegistrationDto;

public interface UserService {

	User save(UserRegistrationDto registrationDto);
	
}
