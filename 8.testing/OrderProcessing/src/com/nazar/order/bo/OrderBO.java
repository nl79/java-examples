package com.nazar.order.bo;

import com.nazar.order.bo.exception.BOException;
import com.nazar.order.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id) throws BOException;
	boolean deleteOrder(int id) throws BOException;

}
