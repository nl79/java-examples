package com.nazar.mockito.scapbook;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ATest {
	
	@Mock
	B b;
	private A a;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@Test
	public void usesVoidMethodShouldCallTheVoidMethod() throws Exception {
		doNothing().when(b).voidmethod();
		assertSame(1,a.usesVoidMethod());
		verify(b).voidmethod();
	}
	
	@Test(expected = RuntimeException.class)
	public void usesVoidMethodShouldthrowRuntimeException() throws Exception {
		doThrow(Exception.class).when(b).voidmethod();
		a.usesVoidMethod();
	}
	
	@Test(expected = RuntimeException.class)
	public void testConsecutiveCalls() throws Exception {
		doNothing().doThrow(Exception.class).when(b).voidmethod();
		
		// Do nothing the first call
		a.usesVoidMethod();
		verify(b).voidmethod();
		
		// Throw exception the second call
		a.usesVoidMethod();
	}

	
}
