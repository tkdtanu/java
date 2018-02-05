package com.tkd.jackson.annotation.setter;

import com.fasterxml.jackson.annotation.JsonSetter;

public class MyBean {

	public int id;
	private String name;
	@JsonSetter("name")
	public void setTheName(String name) {
		this.name = name;
	}
	public String getTheName() {
		return name;
	}
	
	
	
}
