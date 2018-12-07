package com.nazar.trainings.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {
	Greeting greeting;
	@Before
	public void setup() {
		greeting = new GreetingImpl();
	}
	
	@After
	public void teardown() {
		greeting = null;
	}
	
	@Test
	public void greetShouldReturnValidOutput() {
		String result = greeting.greet("Junit");
		
		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsNull() {
		Greeting greeting = new GreetingImpl();
		greeting.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsBlank() {
		Greeting greeting = new GreetingImpl();
		greeting.greet("");
	}

}
