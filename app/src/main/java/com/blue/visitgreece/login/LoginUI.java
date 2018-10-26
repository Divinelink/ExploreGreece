package com.blue.visitgreece.login;

public class LoginUI {

    private String username;
    private String password;

    public LoginUI() { }

    public LoginUI(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
