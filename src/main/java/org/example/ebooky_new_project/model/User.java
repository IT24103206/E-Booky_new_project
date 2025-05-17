package org.example.ebooky_new_project.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,      // use a NAME (like "admin" or "regular")
        include = JsonTypeInfo.As.PROPERTY,
        property = "@type"               // property will be "@type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AdminUser.class, name = "AdminUser"),
        @JsonSubTypes.Type(value = RegularUser.class, name = "RegularUser")
})
public abstract class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(){}

    public User(int userId,String firstName,String lastName,String email,String password){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

