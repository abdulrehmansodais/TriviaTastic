package com.example.triviatastic;


public class User {

    private String name;
    private String password;
    private String Username;
    private String email;
    public User() {}

    public User(String name,String password,String Username,String email) {
        this.name = name;
        this.password=password;
        this.Username=Username;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return Username;
    }
    public String getEmail() {
        return email;
    }

}
