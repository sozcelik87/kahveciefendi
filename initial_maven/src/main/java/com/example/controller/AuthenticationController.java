package com.example.controller;

import java.util.Collections;

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

import com.example.dto.JWTTokenDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RegisterDTO;
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

    
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> login(@RequestBody LoginDTO authenticationRequest) {


        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenProvider.createToken(authentication, false);
            return ResponseEntity.ok(new JWTTokenDTO(token));
        } catch (Exception exception) {
            return new ResponseEntity<>(Collections.singletonMap("Exception", exception.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }

    }
    
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {


        try {
        	
        	customerService.registerCustomer(registerDTO);
        	
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            registerDTO.getEmail(),
                            registerDTO.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenProvider.createToken(authentication, false);
            return ResponseEntity.ok(new JWTTokenDTO(token));
        } catch (Exception exception) {
            return new ResponseEntity<>(Collections.singletonMap("Exception", exception.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

}
