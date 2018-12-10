package com.nazar.mockito.spy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class ListTest {
	
	@Mock
	List<String> myList = Mockito.mock(ArrayList.class);
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test() {
		myList.add("Nazar");
		myList.add("TestUser");
		Mockito.when(myList.get(0)).thenReturn("Rambo");
//		Mockito.doReturn(3).when(myList).size();
//		assertSame(3, myList.size());
	}

}
