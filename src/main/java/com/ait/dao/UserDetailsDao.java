package com.ait.dao;

import com.ait.entity.MyUserDetails;
import com.ait.response.MyUserDetailsResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDetailsDao extends CrudRepository<MyUserDetails, Long> {

    public MyUserDetails findByUserId(String username);

    public MyUserDetails findById(String id);

    public MyUserDetails save(MyUserDetails myUserDetails);
}
