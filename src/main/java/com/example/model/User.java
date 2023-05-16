package com.example.model;

import java.util.Date;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String login;
    private String password;
    private Date createdDate;
    private Date modifiedDate;
    private List<String> roles;

    public User() {

    }

    public User(String name, String login, String password, List<String> roles) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
