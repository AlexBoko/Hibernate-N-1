package com.example.model;

import java.util.List;

public class CreateUserRequest {
    private String name;
    private String login;
    private String password;
    private List<Long> roleIds;


    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String login, String password, List<Long> roleIds) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.roleIds = roleIds;
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

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
