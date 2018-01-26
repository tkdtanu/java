package com.tkd.jackson.annotation.getter;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","name"})
public class MyBean {

	public int id;
	private String name;
	
	@JsonGetter("name")
	public String  getTheName(){
		return name;
	}

	public MyBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
