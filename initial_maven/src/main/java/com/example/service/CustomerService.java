package com.example.service;

import java.util.List;

import com.example.domain.Address;
import com.example.domain.Customer;
import com.example.dto.AddressDTO;
import com.example.dto.RegisterDTO;

public interface CustomerService {
	
	public Customer getCustomerByEmail(String email);
	
	public void registerCustomer(RegisterDTO registerDTO) throws Exception;
	
	public List<AddressDTO> getCustomerAddresses(String email);
	
	public void addCustomerAddress(String email,AddressDTO addressDTO);
}
