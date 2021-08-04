package com.example.model;

public class User {
    private String userName;
    private String userEmail;
    private String userCountry;
    private int userAge;
    private int id;

    public User(String name, String email, String country, int age){
        this.userName = name;
        this.userEmail = email;
        this.userCountry = country;
        this.userAge = age;
    }
    public User(int id, String name, String email, String country, int age) {
        this.id = id;
        this.userName = name;
        this.userEmail = email;
        this.userCountry = country;
        this.userAge = age;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUser(String name) {
        this.userName = name;
    }
    public String getEmail() {
        return this.userEmail;
    }
    public void setEmail(String email) {
        this.userEmail = email; 
    }
    public String getCountry() {
        return this.userCountry;
    }
    public void setCountry(String country) {
        this.userCountry = country; 
    }
    public int getAge() {
        return this.userAge;
    }
    public void setAge(int age) {
        this.userAge = age; 
    }
    public int getId() {
        return this.id;
    }
    public void setId(int age) {
        this.userAge = id; 
    }
}
