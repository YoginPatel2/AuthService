package com.ait.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyUserDetailsResponse {

    private String userId;
    private String role;
    private String firstName;
    private String lastLast;
    private String gender;
    private String mobile;
    private String email;

}
