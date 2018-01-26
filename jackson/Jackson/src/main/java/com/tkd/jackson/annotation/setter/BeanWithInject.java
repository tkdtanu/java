package com.tkd.jackson.annotation.setter;

import com.fasterxml.jackson.annotation.JacksonInject;

public class BeanWithInject {
	@JacksonInject
	public int id;
	
	public String name;

}
