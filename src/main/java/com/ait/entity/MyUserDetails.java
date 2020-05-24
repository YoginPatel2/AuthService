package com.ait.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_details")
public class MyUserDetails implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private String id;
    @Column
    private String username;
    @Column
    private String password;
//    @Column(name = "created_date")
//    private Date createdDate;
//    @Column(name = "created_by")
//    private String createdBy;
//    @Column(name = "updated_date")
//    private Date updatedDate;
//    @Column(name = "updated_by")
//    private String updatedBy;


    public MyUserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public MyUserDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
