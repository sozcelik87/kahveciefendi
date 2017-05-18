
package com.example.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/*
		 * if(authentication.getCredentials().equals("admin")&&authentication.
		 * getPrincipal().equals("admin")){ User user = new User();
		 * user.setUsername((String)authentication.getCredentials());
		 * Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();
		 * userAuthorities.add(new UserAuthority("ROLE_ADMIN"));
		 * userAuthorities.add(new UserAuthority("ROLE_USER"));
		 * user.setAuthorities(userAuthorities); return new
		 * UserAuthentication(user); }
		 */

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.ADMIN));
		grantedAuthorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));

		return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);

	}

	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
