package com.tkd.jackson.annotation.setter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanWithCreater {
	public int id;
	public String name;
	
	@JsonCreator
	public BeanWithCreater(@JsonProperty("id")int id, @JsonProperty("theName")String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
