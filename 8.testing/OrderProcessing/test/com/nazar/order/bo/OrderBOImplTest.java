package com.nazar.order.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.nazar.order.dao.OrderDAO;
import com.nazar.order.dto.Order;

class OrderBOImplTest {
	
	@Mock
	OrderDAO dao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void placeOrder_Should_Create_an_Order() throws SQLException {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setDao(dao);
		
		Order order = new Order();
		
		when(dao.create(order)).thenReturn(new Integer(1));
	}

}
