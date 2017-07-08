package com.example.service;

import com.example.domain.Order;
import com.example.dto.OrderDTO;

public interface OrderService {
	
	public Order saveOrder(OrderDTO orderDTO);
}
