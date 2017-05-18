package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Addition;
import com.example.domain.Beverage;
import com.example.domain.ShoppingCart;
import com.example.domain.ShoppingCartItem;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private HazelcastInstance hazelcastInstance;

	@Autowired
	private BeverageService beverageService;

	@Autowired
	private AdditionService additionService;

	@Override
	public ShoppingCart addItem(String shoppingCartId, Long itemId, List<Long> additionIds, Long quantity) {

		ShoppingCart shoppingCart = new ShoppingCart();

		if (shoppingCartId == null) {
			shoppingCartId = UUID.randomUUID().toString();
		}

		IMap<String, ShoppingCartItem> shoppingCartMap = hazelcastInstance.getMap(shoppingCartId);

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		Beverage beverage = beverageService.findById(itemId);
		beverage.setAdditions(null);
		shoppingCartItem.setBeverage(beverage);
		if (additionIds.size() > 0) {
			List<Addition> additions = additionService.getAdditionsByIdList(additionIds);
			shoppingCartItem.setAdditions(additions);
		}

		if (shoppingCartMap.get(shoppingCartItem.getKey()) == null) {
			shoppingCartItem.setQuantity(quantity);
			shoppingCartMap.put(shoppingCartItem.getKey(), shoppingCartItem);
		} else {
			shoppingCartItem.setQuantity(quantity + shoppingCartMap.get(shoppingCartItem.getKey()).getQuantity());
			shoppingCartMap.put(shoppingCartItem.getKey(), shoppingCartItem);
		}

		shoppingCart.setShoppingCartId(shoppingCartId);
		shoppingCart.setItems(new ArrayList<ShoppingCartItem>(shoppingCartMap.values()));

		return shoppingCart;
	}

	@Override
	public ShoppingCart getShoppingCart(String shoppingCartId) {
		ShoppingCart shoppingCart = new ShoppingCart();

		IMap<String, ShoppingCartItem> shoppingCartMap = hazelcastInstance.getMap(shoppingCartId);

		shoppingCart.setShoppingCartId(shoppingCartId);
		shoppingCart.setItems(new ArrayList<ShoppingCartItem>(shoppingCartMap.values()));
		return shoppingCart;
	}

	@Override
	public ShoppingCart emptyShoppingCart(String shoppingCartId) {

		ShoppingCart shoppingCart = new ShoppingCart();

		IMap<String, ShoppingCartItem> shoppingCartMap = hazelcastInstance.getMap(shoppingCartId);

		shoppingCartMap.clear();

		shoppingCart.setShoppingCartId(shoppingCartId);
		shoppingCart.setItems(new ArrayList<ShoppingCartItem>(shoppingCartMap.values()));
		return shoppingCart;
	}

	@Override
	public ShoppingCart removeItem(String shoppingCartId, String itemKey) {
		ShoppingCart shoppingCart = new ShoppingCart();

		IMap<String, ShoppingCartItem> shoppingCartMap = hazelcastInstance.getMap(shoppingCartId);

		shoppingCartMap.delete(itemKey);

		shoppingCart.setShoppingCartId(shoppingCartId);
		shoppingCart.setItems(new ArrayList<ShoppingCartItem>(shoppingCartMap.values()));
		return shoppingCart;
	}
}
