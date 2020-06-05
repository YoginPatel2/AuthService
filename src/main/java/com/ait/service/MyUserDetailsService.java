package com.ait.service;

import com.ait.dao.UserDetailsDao;
import com.ait.entity.MyUserDetails;
import com.ait.entity.Roles;
import com.ait.request.MyUserDetailsRequest;
import com.ait.request.RolesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public MyUserDetails save(MyUserDetailsRequest myUserDetailsRequest){
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
        return userDetailsDao.save(myUserDetails);
    }

    public MyUserDetails update(MyUserDetailsRequest myUserDetailsRequest, Long id) {
        MyUserDetails userDetails = null;
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
            userDetails = userDetailsDao.save(myUserDetails);
        }
        return userDetails;
    }
}
