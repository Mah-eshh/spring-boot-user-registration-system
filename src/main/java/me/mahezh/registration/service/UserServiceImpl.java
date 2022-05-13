package me.mahezh.registration.service;

import java.util.Arrays;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.mahezh.registration.model.Role;
import me.mahezh.registration.model.User;
import me.mahezh.registration.repository.UserRepository;
import me.mahezh.registration.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

	@Override
	public User save(UserRegistrationDto registrationDto) {

		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

}
