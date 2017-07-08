package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.dto.OrderDTO;
import com.example.dto.OrderResponseDTO;
import com.example.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

    @RequestMapping(value="/complete",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public OrderResponseDTO completeOrder(@RequestBody OrderDTO orderDTO) {
    	Order order=orderService.saveOrder(orderDTO);
    	return new OrderResponseDTO(order.getId());
    }

}