package com.example.service;

import com.example.domain.Customer;
import com.example.dto.RegisterDTO;

public interface CustomerService {
	
	public Customer getCustomerByEmail(String email);
	
	public void registerCustomer(RegisterDTO registerDTO) throws Exception;
}
