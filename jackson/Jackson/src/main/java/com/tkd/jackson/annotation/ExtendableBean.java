package com.tkd.jackson.annotation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class ExtendableBean {
	public String name;
	private Map<String, String> properties = new HashMap<String, String>();
	
	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	public ExtendableBean(String name) {
		this.name = name;
	}
	
	public void add(String key,String value){
		properties.put(key, value);
	}
	
	

}
