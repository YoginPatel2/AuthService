package com.ait.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_details")
public class MyUserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Roles roles;

    @Column(unique = true)
    private String userId;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastLast;
    @Column
    private String gender;
    @Column
    private String mobile;
    @Column
    private String email;
    @Column
    private Long createdDate;

    public MyUserDetails(String username, String password) {
        this.userId = username;
        this.password = password;
    }

    public MyUserDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastLast() {
        return lastLast;
    }

    public void setLastLast(String lastLast) {
        this.lastLast = lastLast;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
