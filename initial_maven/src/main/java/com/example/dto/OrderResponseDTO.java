package com.example.dto;

public class OrderResponseDTO {

	private Long orderId;
	
	public OrderResponseDTO(Long orderId) {
		super();
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}