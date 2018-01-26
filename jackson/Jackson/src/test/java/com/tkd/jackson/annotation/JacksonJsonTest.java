package com.tkd.jackson.annotation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tkd.jackson.annotation.ExtendableBean;
import com.tkd.jackson.annotation.MyBean;
import com.tkd.jackson.annotation.RawBean;
import com.tkd.jackson.annotation.TypeEnumWithValue;

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
}
