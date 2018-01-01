package com.tkd.springmvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tkd.springmvc.service.EmailService;

/**
 * @author tarun.das
 *
 */
public class SpringConditionalAnnotationApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.tkd.springmvc");
		EmailService emailSerivice = context.getBean("emailService", EmailService.class);
		if(emailSerivice != null) {
			System.out.println("********************************************");
			System.out.println("Server Name:" +emailSerivice.serverName());
			System.out.println("********************************************");
		}
		context.close();
	}
}
