package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

public class ShoppingCartItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Beverage beverage;
	
	private List<Addition> additions= new ArrayList<Addition>();
	
	private Long quantity;

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public String getKey(){
		String key =beverage.getId().toString();
		for(Addition addition : additions){
			key+="-";
			key+=addition.getId().toString();
		}
		return key;
	}
	
	public Long getTotalPrice(){
		
		return getUnitPrice()*quantity;
	}
	
	public Long getUnitPrice(){
		Long unitPrice = beverage.getPrice();
		for(Addition addition : additions){
			unitPrice+=addition.getPrice();
		}
		return unitPrice;
	}
	
	public String getDescription(){
		StringBuilder description = new StringBuilder(beverage.getName());
		if(additions.size()>0){
			description.append("(");
			List<String> additionNames = additions.stream().map(addition -> addition.getName()).collect(Collectors.toList());
			description.append(String.join(",",additionNames));
			description.append(")");
		}
		return description.toString();
	}
}


