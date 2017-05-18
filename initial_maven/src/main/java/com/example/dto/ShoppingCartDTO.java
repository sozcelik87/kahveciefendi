package com.example.dto;

import java.util.List;

import com.example.domain.ShoppingCartItem;

public class ShoppingCartDTO {
	
	private String shoppingCartId;
	
	List<ShoppingCartItem> items;

	public String getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}
}
