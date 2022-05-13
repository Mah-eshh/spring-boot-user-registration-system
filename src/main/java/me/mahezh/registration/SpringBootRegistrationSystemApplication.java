package me.mahezh.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringBootRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegistrationSystemApplication.class, args);
	}

}
