package com.ait.service;

import com.ait.dao.UserDetailsDao;
import com.ait.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        MyUserDetails myUserDetails = userDetailsDao.findById("1001");
        System.out.println(myUserDetails.getPassword() +" <Wrong> "+myUserDetails.getUsername());
        System.out.println(myUserDetails.getUsername() +" <Right> "+myUserDetails.getPassword());
        return new User(myUserDetails.getUsername(),myUserDetails.getPassword(),new ArrayList<>());
    }
}
