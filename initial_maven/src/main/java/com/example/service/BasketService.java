package com.example.service;

import java.util.List;

import com.example.domain.Item;

public interface BasketService {
	
	public List<Item> addItemToBasket(String basketId,Item item);
}
