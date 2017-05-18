package com.example.domain;

import java.util.List;

public class ShoppingCart {
	
	private String shoppingCartId;
	
	private List<ShoppingCartItem> items;

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
	
	public Long getTotalPrice(){
		Long totalPrice =0L;
		for(ShoppingCartItem item :items){
			totalPrice+=item.getTotalPrice();
		}
		return totalPrice;
	}
}
