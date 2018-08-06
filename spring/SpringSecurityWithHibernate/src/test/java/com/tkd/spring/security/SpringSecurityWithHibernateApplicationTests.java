package com.tkd.spring.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("it")
@AutoConfigureMockMvc
public class SpringSecurityWithHibernateApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testShouldPassWithValidCredential() throws Exception {
		this.mockMvc
			.perform(get("/users").with(httpBasic("tkdtanu@gmail.com", "password")))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testShouldFailWithInvalidCredential() throws Exception {
		this.mockMvc
		.perform(get("/users").with(httpBasic("tarun", "password")))
		.andExpect(status().is4xxClientError());
	}

}
