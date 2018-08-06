package com.tkd.spring.security;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tkd.spring.security.model.Role;
import com.tkd.spring.security.model.User;
import com.tkd.spring.security.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityWithHibernateApplication {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithHibernateApplication.class, args);
	}
	
	@PostConstruct
	public void run() {
		User user = new User("Tarun",
							"Das",
							"tkdtanu@gmail.com",
							passwordEncoder.encode("password"),
							Arrays.asList(new Role("ROLE_USER"), new Role("ROLE_ADMIN")));
		if(userRepository.findByEmail(user.getEmail()) == null) {
			userRepository.save(user);
		}
	}
}
