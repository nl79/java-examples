package com.nazar.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class GreetingImplTest {
	Greeting greeting;
	@BeforeEach
	public void setup() {
		greeting = new GreetingImpl();
	}
	
	@AfterEach
	public void teardown() {
		greeting = null;
	}
	
	@Test
	public void greetShouldReturnValidOutput() {
		String result = greeting.greet("Junit");
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Junit", result);
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		Greeting greeting = new GreetingImpl();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			greeting.greet(null);
		});
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {
		Greeting greeting = new GreetingImpl();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			greeting.greet("");
		});
	}

}
