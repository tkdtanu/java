package com.tkd.jackson.annotation.getter;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tkd.jackson.serializer.CustomDateSerializer;

public class Event {

	public String name;

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date eventDate;

	public Event(String name, Date eventDate) {
		super();
		this.name = name;
		this.eventDate = eventDate;
	}

}
