package com.ait.controller;

import com.ait.request.MyUserDetailsRequest;
import com.ait.response.MyUserDetailsResponse;
import com.ait.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody MyUserDetailsRequest userDetailsRequest){
        return ResponseEntity.ok(myUserDetailsService.save(userDetailsRequest));
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody MyUserDetailsRequest userDetailsRequest, @PathVariable Long id){
        MyUserDetailsResponse myUserDetails = myUserDetailsService.update(userDetailsRequest,id);
        if(myUserDetails != null){
            return ResponseEntity.ok(myUserDetails);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("User Not Found"); //status(HttpStatus.NOT_MODIFIED);
        }
    }
}
