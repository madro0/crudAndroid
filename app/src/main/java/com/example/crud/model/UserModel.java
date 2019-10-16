package com.example.crud.model;

public class UserModel {
    private String Name, LastName, Email, Password;
    private int Id;

    public UserModel() {
    }

    public UserModel(String name, String lastName, String email, String password, int id) {
        Name = name;
        LastName = lastName;
        Email = email;
        Password = password;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
