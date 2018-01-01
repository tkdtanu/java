package com.tkd.springmvc.service.impl;

import com.tkd.springmvc.service.EmailService;

public class LinuxEmailService implements EmailService {
	private final String SERVER_NAME= "Linux";
	@Override
	public String serverName() {
		return SERVER_NAME;
	}

}
