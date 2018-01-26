package com.tkd.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.tkd.springmvc.condition.LinuxCondition;
import com.tkd.springmvc.condition.WindowsCondition;
import com.tkd.springmvc.service.EmailService;
import com.tkd.springmvc.service.impl.LinuxEmailService;
import com.tkd.springmvc.service.impl.WindowsEmailService;

/**
 * @author tarun.das
 *
 */
@Configuration
public class MyConfiguration {
	@Bean(name="emailService")
	@Conditional(WindowsCondition.class)
	public EmailService windowsEmailerService() {
		return new WindowsEmailService();
	}
	
	@Bean(name="emailService")
	@Conditional(LinuxCondition.class)
	public EmailService linuxEmailService() {
		return new LinuxEmailService();
	}
}
