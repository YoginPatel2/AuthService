package com.ait.request;

import java.io.Serializable;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class MyUserDetailsRequest implements Serializable {

    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String mobile;
    private String email;
    private RolesRequest roles;

    public MyUserDetailsRequest() {
    }

    public MyUserDetailsRequest(String userId, String password, String firstName, String lastName, String gender, String mobile, String email, RolesRequest roles) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.roles = roles;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public RolesRequest getRoles() {
        return roles;
    }

    public void setRoles(RolesRequest roles) {
        this.roles = roles;
    }
}
