package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.Address;
import com.example.domain.Customer;
import com.example.dto.AddressDTO;
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
		
		Customer cust = getCustomerByEmail(registerDTO.getEmail());
		
		if(cust!=null){
			throw new Exception("Email adress is already in use");
		}
		
		Customer customer = new Customer();
    	customer.setEmail(registerDTO.getEmail());
    	customer.setName(registerDTO.getName());
    	customer.setSurname(registerDTO.getSurname());
    	customer.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
    	
		customerRepository.save(customer);
	}

	@Override
	public List<AddressDTO> getCustomerAddresses(String email) {
		Customer customer = customerRepository.findByEmail(email);
		List<AddressDTO> addresses = new ArrayList<>();
		for(Address address : customer.getAddresses()){
				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setId(address.getId());
				addressDTO.setTitle(address.getTitle());
				addressDTO.setPhone(address.getPhone());
				addressDTO.setAddress(address.getAddress());
				addressDTO.setAddressDetail(address.getAddressDetail());
				addresses.add(addressDTO);
		}
		return addresses;
	}

	@Override
	public void addCustomerAddress(String email,AddressDTO addressDTO) {
		Customer customer = getCustomerByEmail(email);
		
		Address address = new Address();
		address.setTitle(addressDTO.getTitle());
		address.setPhone(addressDTO.getPhone());
		address.setAddress(addressDTO.getAddress());
		address.setAddressDetail(addressDTO.getAddressDetail());
		address.setCustomer(customer);
		customer.getAddresses().add(address);
		customerRepository.save(customer);
	}

}
