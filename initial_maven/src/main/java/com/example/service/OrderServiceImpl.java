package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.domain.Address;
import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.domain.PaymentType;
import com.example.domain.ShoppingCart;
import com.example.domain.ShoppingCartItem;
import com.example.dto.OrderDTO;
import com.example.repository.AddressRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.repository.PaymentTypeRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PaymentTypeRepository paymentTypeRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Order saveOrder(OrderDTO orderDTO) {
		String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Customer customer = customerRepository.findByEmail(email);
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(orderDTO.getShoppingCartId());
		Address deliveryAddress = addressRepository.findOne(orderDTO.getDeliveryAddressId());
		PaymentType paymentType = paymentTypeRepository.findOne(orderDTO.getPaymentTypeId());
		
		Order order = new Order();
		order.setDeliveryAddress(deliveryAddress);
		order.setPaymentType(paymentType);
		order.setCustomer(customer);
		order.setDiscount(shoppingCart.getDiscount());
		order.setTotalPrice(shoppingCart.getTotalPrice());
		order.setDiscountedPrice(shoppingCart.getDiscountedPrice());
		List<OrderItem> orderItems =new ArrayList<>();
		for(ShoppingCartItem shoppingItem : shoppingCart.getItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setItemName(shoppingItem.getDescription());
			orderItem.setQuantity(shoppingItem.getQuantity());
			orderItem.setUnitPrice(shoppingItem.getUnitPrice());
			orderItem.setTotalPrice(shoppingItem.getTotalPrice());
		}
		order.setOrderItems(orderItems);
		
		
		return orderRepository.save(order);
	}

}
