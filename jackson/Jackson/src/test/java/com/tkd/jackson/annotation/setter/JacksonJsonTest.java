package com.tkd.jackson.annotation.setter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tkd.jackson.annotation.setter.ExtendableBean;

public class JacksonJsonTest {
	@Test
	public void whenDeSerializingUsingJsonCreator_thenCorrect() throws IOException {

		String json = "{\"id\":1,\"theName\":\"My bean\"}";
		BeanWithCreater bean = new ObjectMapper().readerFor(BeanWithCreater.class).readValue(json);
		assertEquals("My bean", bean.name);
	}

	@Test
	public void whenDeSerializingUsingJsonInject_thenCorrect() throws IOException {

		String json = "{\"name\":\"My bean\"}";
		InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);
		BeanWithInject bean = new ObjectMapper().reader(inject).forType(BeanWithInject.class).readValue(json);

		assertEquals("My bean", bean.name);
		assertEquals(1, bean.id);
	}

	@Test
	public void whenDeSerializingUsingJsonAnySetter_thenCorrect() throws IOException{

		String json
	      = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
		
		ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class).readValue(json);

		assertEquals("My bean", bean.name);
		assertEquals("val2", bean.getProperties().get("attr2"));
	}
}
