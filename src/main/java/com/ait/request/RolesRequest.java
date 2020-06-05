package com.ait.request;

import java.io.Serializable;

public class RolesRequest implements Serializable {
    private String role;

    public RolesRequest() {
    }

    public RolesRequest(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
