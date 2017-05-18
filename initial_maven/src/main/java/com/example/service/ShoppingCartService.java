package com.example.service;

import java.util.List;

import com.example.domain.ShoppingCart;

public interface ShoppingCartService {
	
	public ShoppingCart addItem(String shoppingCartId,Long itemId,List<Long> additions,Long quantity); 
	
	public ShoppingCart getShoppingCart(String shoppingCartId);
	
	public ShoppingCart emptyShoppingCart(String shoppingCartId);
	
	public ShoppingCart removeItem(String shoppingCartId,String itemKey);
	
}
