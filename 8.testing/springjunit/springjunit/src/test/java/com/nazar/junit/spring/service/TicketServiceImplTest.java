package com.nazar.junit.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nazar.junit.spring.dao.TicketDAO;
import com.nazar.junit.spring.dto.Ticket;

// Will use the spring runner to scan the files and process the specific annotations. 
@RunWith(SpringJUnit4ClassRunner.class)
// Location of the configuration files. It wills can all files in that directory and desendeants and create 
// the objects annotated with Spring annotations.
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int RESULT = 1;
	private static final String PASSENGER_NAME = "Nazar";
	private static final String PHONE = "234234";

	@Mock
	TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buyTicketsShouldREturnAValidValue() {
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket(PASSENGER_NAME, PHONE);

		assertEquals(result, RESULT);
	}

}
