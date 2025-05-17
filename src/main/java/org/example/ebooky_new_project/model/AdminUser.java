package org.example.ebooky_new_project.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({})
public class AdminUser extends User{
    private String adminRole;

    public AdminUser(){
        super();
    }

    public AdminUser(int userId,String firstName,String lastName,String email,String password,String adminRole){
        super(userId,firstName,lastName,email,password);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
}
