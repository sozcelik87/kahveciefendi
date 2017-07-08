package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AddressDTO;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

    @RequestMapping(value="/list/addresses",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<AddressDTO> listCustomerAddresses() {
    	String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    	return customerService.getCustomerAddresses(email);
    }
    
    @RequestMapping(value="/add/address",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<AddressDTO> addCustomerAddress(@RequestBody AddressDTO addressDTO) {
    	String email = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    	
    	customerService.addCustomerAddress(email,addressDTO);
    	return customerService.getCustomerAddresses(email);
    }
}