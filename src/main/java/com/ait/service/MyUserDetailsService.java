package com.ait.service;

import com.ait.dao.UserDetailsDao;
import com.ait.entity.MyUserDetails;
import com.ait.request.MyUserDetailsRequest;
import com.ait.response.MyUserDetailsResponse;
import org.modelmapper.ModelMapper;
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

        MyUserDetails myUserDetails = userDetailsDao.findByUserId(userName);
        return new User(myUserDetails.getUserId(),myUserDetails.getPassword(),new ArrayList<>());
    }
    public MyUserDetails createUser(MyUserDetailsRequest myUserDetailsRequest){
        ModelMapper modelMapper = new ModelMapper();
        MyUserDetails userDetails = modelMapper.map(myUserDetailsRequest,MyUserDetails.class);
        return userDetailsDao.save(userDetails);
    }
}
