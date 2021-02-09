package com.yehyaayash99.hakini.Items;

public class DataLogin {

    private int id;
    private String email, username, api_token;

    public DataLogin(int id, String email, String username, String api_token) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.api_token = api_token;
    }

    public DataLogin() {
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
