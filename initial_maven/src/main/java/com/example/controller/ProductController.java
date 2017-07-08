package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Beverage;
import com.example.service.BeverageService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private BeverageService beverageService;

    @RequestMapping(value="/list/beverages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Beverage> listBeverages() {
    	return beverageService.listBeverages();
    }
}