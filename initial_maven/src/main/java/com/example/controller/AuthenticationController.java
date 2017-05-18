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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AuthRequestDTO;
import com.example.dto.JWTTokenDTO;
import com.example.security.JWTConfigurer;
import com.example.security.TokenProvider;


@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private TokenProvider tokenProvider;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    
    @RequestMapping(value = "/signin",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthRequestDTO authenticationRequest, HttpServletResponse response) {


        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
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

    /**
     * GET  /users : get all the users which are on sale.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of users in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
//    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
//    public List<User> getUsers() throws URISyntaxException {
//        log.debug("REST request to get a list of users");
//        //return userService.findAll();
//    }

}
