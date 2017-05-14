package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.hazelcast.core.HazelcastInstance;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private HazelcastInstance hazelcastInstance;

	@Override
	public List<Item> addItemToBasket(String basketId,Item item) {
		List<Item> basket = hazelcastInstance.getList(basketId);
		basket.add(item);
		return basket;
	}
}
