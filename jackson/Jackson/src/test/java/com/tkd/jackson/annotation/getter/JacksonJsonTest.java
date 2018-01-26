package com.tkd.jackson.annotation.getter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tkd.jackson.annotation.getter.Event;
import com.tkd.jackson.annotation.getter.ExtendableBean;
import com.tkd.jackson.annotation.getter.MyBean;
import com.tkd.jackson.annotation.getter.RawBean;
import com.tkd.jackson.annotation.getter.TypeEnumWithValue;
import com.tkd.jackson.annotation.getter.UserWithRoot;
import com.tkd.jackson.annotation.setter.BeanWithCreater;
import com.tkd.jackson.annotation.setter.BeanWithInject;

import org.junit.matchers.JUnitMatchers;

public class JacksonJsonTest {

	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
		ExtendableBean bean = new ExtendableBean("My Bean");
		bean.add("attr1", "val1");
		bean.add("attr2", "val2");

		String result = new ObjectMapper().writeValueAsString(bean);

		System.out.println(result);

		assertThat(result, JUnitMatchers.containsString("attr1"));
		assertThat(result, JUnitMatchers.containsString("val1"));
	}

	@Test
	public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
		MyBean bean = new MyBean(1, "My Bean");
		String result = new ObjectMapper().writeValueAsString(bean);

		System.out.println(result);

		assertThat(result, JUnitMatchers.containsString("My Bean"));
		assertThat(result, JUnitMatchers.containsString("1"));
	}

	@Test
	public void whenSerializingUsingJsonPropertyOrder_thenCorrect() throws JsonProcessingException {
		MyBean bean = new MyBean(1, "My Bean");
		String result = new ObjectMapper().writeValueAsString(bean);

		System.out.println(result);

		assertThat(result, JUnitMatchers.containsString("My Bean"));
		assertThat(result, JUnitMatchers.containsString("1"));
	}

	@Test
	public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {
		RawBean bean = new RawBean("My Bean", "{\"attr\":false}");
		String result = new ObjectMapper().writeValueAsString(bean);

		System.out.println(result);

		assertThat(result, JUnitMatchers.containsString("My Bean"));
		assertThat(result, JUnitMatchers.containsString("{\"attr\":false}"));
	}

	@Test
	public void whenSerializingUsingJsonValue_thenCorrect() throws JsonProcessingException {

		String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
		System.out.println(enumAsString);

		assertThat(enumAsString, is("\"Type A\""));
	}

	@Test
	public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {
		UserWithRoot user = new UserWithRoot(1, "Tarun");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String result = mapper.writeValueAsString(user);

		System.out.println(result);

		assertThat(result, JUnitMatchers.containsString("user"));
		assertThat(result, JUnitMatchers.containsString("Tarun"));
	}

	@Test
	public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String toParse = "20-12-2014 02:30:00";

		Date date = formatter.parse(toParse);

		Event event = new Event("party", date);

		String result = new ObjectMapper().writeValueAsString(event);

		System.out.println(result);

		assertThat(result, JUnitMatchers.containsString(toParse));
	}
}
