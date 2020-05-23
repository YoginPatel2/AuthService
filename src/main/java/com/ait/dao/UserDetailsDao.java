package com.ait.dao;

import com.ait.entity.MyUserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDetailsDao  {

    @PersistenceContext
    private EntityManager entityManager;

    public MyUserDetails findByUsername(String username) {
        return entityManager.find(MyUserDetails.class, username);
    }
    public MyUserDetails findById(String id) {
        return entityManager.find(MyUserDetails.class, id);
    }

}
