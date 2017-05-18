package com.example.dto;

import java.util.List;

public class ShoppingCartItemDTO {
	
	private String shoppingCartId;
	
	private Long itemId;
	
	private List<Long> additions;
	
	private Long quantity;

	public String getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public List<Long> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Long> additions) {
		this.additions = additions;
	}
}
