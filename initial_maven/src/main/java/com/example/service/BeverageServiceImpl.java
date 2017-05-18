package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Beverage;
import com.example.domain.Product;
import com.example.repository.BeverageRepository;
import com.example.repository.ProductRepository;

@Service
public class BeverageServiceImpl implements BeverageService {
	
	@Autowired
	private BeverageRepository beverageRepository;

	@Override
	public List<Beverage> listBeverages() {
		return beverageRepository.findAll();
	}

	@Override
	public Beverage findById(Long id) {
		return beverageRepository.findOne(id);
	}
	
}
