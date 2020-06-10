package com.ait.service;

import com.ait.dao.UserDetailsDao;
import com.ait.entity.MyUserDetails;
import com.ait.entity.Roles;
import com.ait.request.MyUserDetailsRequest;
import com.ait.response.MyUserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        MyUserDetails myUserDetails = userDetailsDao.findByUserId(userName);
        return new User(myUserDetails.getUserId(),myUserDetails.getPassword(), true, true, true, true, getAuthorities(myUserDetails));
    }
    private Collection<GrantedAuthority> getAuthorities(MyUserDetails myUserDetails) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new SimpleGrantedAuthority(myUserDetails.getRoles().getName()));
        return authList;
    }
//    private Set getAuthority(MyUserDetails user) {
//        Set authorities = new HashSet<>();
//        authorities.add(user.getRoles().getName());
//        return authorities;
//    }

    public MyUserDetailsResponse save(MyUserDetailsRequest myUserDetailsRequest){
//        ModelMapper modelMapper = new ModelMapper();
//        MyUserDetails userDetails = modelMapper.map(myUserDetailsRequest,MyUserDetails.class);

        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUserId(myUserDetailsRequest.getUserId());
        myUserDetails.setPassword(myUserDetailsRequest.getPassword());
        myUserDetails.setFirstName(myUserDetailsRequest.getFirstName());
        myUserDetails.setLastLast(myUserDetailsRequest.getLastName());
        myUserDetails.setMobile(myUserDetailsRequest.getMobile());
        myUserDetails.setGender(myUserDetailsRequest.getGender());
        myUserDetails.setCreatedDate(new Date().getTime());
        myUserDetails.setEmail(myUserDetailsRequest.getEmail());
        Roles roles = new Roles();
        roles.setName(myUserDetailsRequest.getRoles().getRole());
        myUserDetails.setRoles(roles);
        return  mapUserDetails(userDetailsDao.save(myUserDetails));
    }
    private MyUserDetailsResponse mapUserDetails(MyUserDetails myUserDetails){
        MyUserDetailsResponse response = new MyUserDetailsResponse();
        response.setUserId(myUserDetails.getUserId());
        response.setRole(myUserDetails.getRoles().getName());
        response.setFirstName(myUserDetails.getFirstName());
        response.setLastLast(myUserDetails.getLastLast());
        response.setGender(myUserDetails.getGender());
        response.setMobile(myUserDetails.getMobile());
        response.setEmail(myUserDetails.getEmail());
        return response;
    }

    public MyUserDetailsResponse update(MyUserDetailsRequest myUserDetailsRequest, Long id) {
        MyUserDetailsResponse userDetails = null;
        if(userDetailsDao.existsById(id)) {
            MyUserDetails myUserDetails = new MyUserDetails();
            myUserDetails.setId(id);
            myUserDetails.setUserId(myUserDetailsRequest.getUserId());
            myUserDetails.setPassword(myUserDetailsRequest.getPassword());
            myUserDetails.setFirstName(myUserDetailsRequest.getFirstName());
            myUserDetails.setLastLast(myUserDetailsRequest.getLastName());
            myUserDetails.setMobile(myUserDetailsRequest.getMobile());
            myUserDetails.setGender(myUserDetailsRequest.getGender());
            myUserDetails.setCreatedDate(new Date().getTime());
            myUserDetails.setEmail(myUserDetailsRequest.getEmail());
            userDetails = mapUserDetails(userDetailsDao.save(myUserDetails));
        }
        return userDetails;
    }
}
