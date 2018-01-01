package com.tkd.springmvc.service.impl;

import com.tkd.springmvc.service.EmailService;

public class WindowsEmailService implements EmailService {
	private final String SERVER_NAME= "Windows";
	
	@Override
	public String serverName() {
		return SERVER_NAME;
	}

}
