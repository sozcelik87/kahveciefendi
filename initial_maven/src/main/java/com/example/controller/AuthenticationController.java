package com.example.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;
import com.example.dto.RegisterDTO;
import com.example.domain.Customer;
import com.example.dto.JWTTokenDTO;
import com.example.security.JWTConfigurer;
import com.example.security.TokenProvider;
import com.example.service.CustomerService;


@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private TokenProvider tokenProvider;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    
    @RequestMapping(value = "/signin",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> signIn(@RequestBody LoginDTO authenticationRequest, HttpServletResponse response) {


        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createToken(authentication, false);
            response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return ResponseEntity.ok(new JWTTokenDTO(jwt));
        } catch (Exception exception) {
            return new ResponseEntity<>(Collections.singletonMap("AuthenticationException", exception.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }

    }
    
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO,HttpServletResponse response) {


        try {
        	
        	customerService.registerCustomer(registerDTO);
        	
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            registerDTO.getEmail(),
                            registerDTO.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createToken(authentication, false);
            response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return ResponseEntity.ok(new JWTTokenDTO(jwt));
        } catch (Exception exception) {
            return new ResponseEntity<>(Collections.singletonMap("AuthenticationException", exception.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

}
