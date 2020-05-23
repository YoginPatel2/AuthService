package com.ait.controller;

import com.ait.request.AuthenticationRequest;
import com.ait.response.AuthenticationResponse;
import com.ait.service.MyUserDetailsService;
import com.ait.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/test")
    public String getHello(){
        return "Welcome to Auth Service";
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest auth) throws Exception{
        System.out.println(auth.getUsername());
        System.out.println(auth.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(),auth.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Username or Password",e);
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(auth.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(tokenUtil.generateToken(userDetails)));
    }
}
