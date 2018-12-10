package com.nazar.junit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nazar.junit.spring.dao.TicketDAO;
import com.nazar.junit.spring.dto.Ticket;

@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO dao;

	public int buyTicket(String name, String phone) {
		Ticket ticket = new Ticket();
		ticket.setPassangerName(name);
		ticket.setPhone(phone);

		return getDao().createTicket(ticket);
	}

	public TicketDAO getDao() {
		return dao;
	}

	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}

}
