package com.tkd.spring.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/admin")
	public String getAdminData() {
		return "Welcome to Admin Page";
	}
	@GetMapping("/user")
	public String getUserData() {
		return "Welcome to User Page";
	}
	@GetMapping("/generalUser")
	public String getGeneralUserData() {
		return "Welcome to General User Page";
	}
}
