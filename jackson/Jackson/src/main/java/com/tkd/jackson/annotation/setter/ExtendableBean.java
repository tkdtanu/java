package com.tkd.jackson.annotation.setter;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableBean {
	public String name;
	private Map<String, String> properties = new HashMap<String, String>();
	
	public Map<String, String> getProperties() {
		return properties;
	}
	
	@JsonAnySetter
	public void add(String key,String value){
		properties.put(key, value);
	}
}
