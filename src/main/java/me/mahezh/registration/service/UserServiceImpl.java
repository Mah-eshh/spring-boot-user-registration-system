package me.mahezh.registration.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import me.mahezh.registration.model.Role;
import me.mahezh.registration.model.User;
import me.mahezh.registration.repository.UserRepository;
import me.mahezh.registration.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}


	@Override
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//retrieve user object from the repository
		User user = userRepository.findByEmail(username);
		//check whter null or not
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		//if user is not null create a user object, and pass email password, roles to the user object
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	//map
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		//convert roles into stream.here stream is a map method. 
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
