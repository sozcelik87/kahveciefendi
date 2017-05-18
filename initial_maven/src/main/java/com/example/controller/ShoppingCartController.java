package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ShoppingCart;
import com.example.dto.ShoppingCartItemDTO;
import com.example.service.ShoppingCartService;

@RestController
@RequestMapping("/api/v1/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	

    @RequestMapping(value="/addItem",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addItem(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO) {
    	
    	ShoppingCart shoppingCart = shoppingCartService.addItem(shoppingCartItemDTO.getShoppingCartId(),shoppingCartItemDTO.getItemId(),shoppingCartItemDTO.getAdditions(),shoppingCartItemDTO.getQuantity());
    	
    	return ResponseEntity.ok(shoppingCart);
    }
    
    @RequestMapping(value="/getShoppingCart/{shoppingCartId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getShoppingCart(@PathVariable("shoppingCartId")String shoppingCartId) {
    	
    	ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(shoppingCartId);
    	
    	return ResponseEntity.ok(shoppingCart);
    }
    
    @RequestMapping(value="/emptyShoppingCart/{shoppingCartId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> emptyShoppingCart(@PathVariable("shoppingCartId")String shoppingCartId) {
    	
    	ShoppingCart shoppingCart = shoppingCartService.emptyShoppingCart(shoppingCartId);
    	
    	return ResponseEntity.ok(shoppingCart);
    }
    
    @RequestMapping(value="/removeItem/{shoppingCartId}/{itemKey}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeItem(@PathVariable("shoppingCartId")String shoppingCartId,@PathVariable("itemKey")String itemKey) {
    	
    	ShoppingCart shoppingCart = shoppingCartService.removeItem(shoppingCartId, itemKey);
    	
    	return ResponseEntity.ok(shoppingCart);
    }
}