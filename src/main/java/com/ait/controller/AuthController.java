package com.ait.controller;

import com.ait.entity.MyUserDetails;
import com.ait.request.AuthenticationRequest;
import com.ait.request.MyUserDetailsRequest;
import com.ait.response.AuthenticationResponse;
import com.ait.response.MyUserDetailsResponse;
import com.ait.service.MyUserDetailsService;
import com.ait.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @GetMapping("/validate")
    public String getValidate(){
            return "Welcome to Auth Service";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest auth) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(),auth.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Username or Password",e);
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(auth.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(tokenUtil.generateToken(userDetails)));
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody MyUserDetailsRequest userDetailsRequest){
        return ResponseEntity.ok(myUserDetailsService.createUser(userDetailsRequest));
    }
}
