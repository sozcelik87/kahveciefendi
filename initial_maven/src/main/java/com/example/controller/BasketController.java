package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Item;
import com.example.dto.ItemDTO;
import com.example.repository.ItemRepository;
import com.example.service.BasketService;
import com.example.service.ItemService;

@RestController
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private ItemRepository itemRepository;

    @RequestMapping("/addItem/{itemId}")
    public List<Item> addItem(@PathVariable("itemId") Long itemId) {
    	Item item = itemRepository.findOne(itemId);
    	return basketService.addItemToBasket("suleyman",item);
    }
}