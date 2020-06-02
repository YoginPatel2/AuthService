package com.ait.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyUserDetailsRequest {

    private String userId;
    private String password;
    private String firstName;
    private String lastLast;
    private String gender;
    private String mobile;
    private String email;
    private Date createdDate;
}
