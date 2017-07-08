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
	
	public Long getDiscount(){
		Long discount =0L;
		
		Long totalPrice = getTotalPrice();
		
		if(totalPrice>1200){
			discount = getTotalPrice()/4; // %25 discount;
		}
		
		// 3 or more beverage
		int totalItemCount =0;
		Long cheapestItemPrice =null;
		for(ShoppingCartItem item :items){
			totalItemCount+=item.getQuantity();
			if(cheapestItemPrice == null || item.getUnitPrice()<cheapestItemPrice){
				cheapestItemPrice = item.getUnitPrice();
			}
		}
		
		if(totalItemCount>=3&&cheapestItemPrice>discount){
			discount =cheapestItemPrice;
		}
		
		return discount;
	}
	
	public Long getDiscountedPrice(){
		return getTotalPrice()-getDiscount();
	}
}
