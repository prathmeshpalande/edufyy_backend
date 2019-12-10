package com.edufyy.backend.model;

public class SignupRequest {

    private String name;
    private String email;
    private String phone;
    private String source;
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String name, String email, String phone, String source, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.source = source;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
