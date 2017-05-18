package com.example.service;

import java.util.List;

import com.example.domain.Beverage;

public interface BeverageService {
	
	public List<Beverage> listBeverages();
	
	public Beverage findById(Long id);
}
