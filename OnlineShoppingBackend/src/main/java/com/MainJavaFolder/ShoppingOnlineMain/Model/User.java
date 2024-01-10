package com.MainJavaFolder.ShoppingOnlineMain.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer uid;
    @JsonProperty("user_name")
    private String username;
    private String email;
    private String password;


    public String getUsername()
    {
        return username;

    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
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


    

}
