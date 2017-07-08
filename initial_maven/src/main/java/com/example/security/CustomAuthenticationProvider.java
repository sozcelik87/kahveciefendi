
package com.example.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerService customerService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		String email = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		Customer customer = customerService.getCustomerByEmail(email);
		
		if(customer==null){
			throw new UsernameNotFoundException("User not found");
		}
		
		if(passwordEncoder.matches(password,customer.getPassword())){
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			//grantedAuthorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
			return new UsernamePasswordAuthenticationToken(email, password, grantedAuthorities);
		}else{
			throw new BadCredentialsException("Wrong password");
		}
	}

	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
