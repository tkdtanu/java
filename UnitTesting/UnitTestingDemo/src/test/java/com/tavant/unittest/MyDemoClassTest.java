package com.tavant.unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MyDemoClassTest {
	@Mock
	MyDemoDataClass data = new MyDemoDataClass();
	
	MyDemoClass obj = new MyDemoClass();
	
	@Before
	public void before() {
		System.out.println("Before Each Test");
	}
	
	@After
	public void after() {
		System.out.println("After Each Test");
		
	}
	
	@Test
	public void testShouldRetrunCorrectValue() {
		String result = obj.concatinateString("abc", "cde");
		assertEquals("abccde", result);
	}
	
	@Test(expected=NullPointerException.class)
	public void testShouldBeNPE() {
		obj.concatinateString(null, "abc");
		
	}
	@Test
	public void testShouldReturnAllStudents() {
/*		when(data).thenReturn(new MyDemoDataClass());
*/		 when(data.getAllStudentsName()).thenReturn(Arrays.asList("Rahul","Pramod", "Tanu", "Rakesh"));
			List<String> students = data.getAllStudentsName();
		System.out.println(students);
	}

}
