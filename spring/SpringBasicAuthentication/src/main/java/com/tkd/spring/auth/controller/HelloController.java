package com.tkd.spring.auth.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		System.out.println(SecurityContextHolder.getContext());
		return "index";
	}
}
