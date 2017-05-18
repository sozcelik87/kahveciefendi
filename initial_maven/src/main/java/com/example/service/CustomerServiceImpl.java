package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.dto.RegisterDTO;
import com.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public void registerCustomer(RegisterDTO registerDTO) throws Exception {
		
		if(!registerDTO.getPassword().equals(registerDTO.getRePassword())){
			throw new Exception("Passwords are not match");	
		}
		
		Customer customer = new Customer();
    	customer.setEmail(registerDTO.getEmail());
    	customer.setName(registerDTO.getName());
    	customer.setSurname(registerDTO.getSurname());
    	customer.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
    	
		customerRepository.save(customer);
	}

}
