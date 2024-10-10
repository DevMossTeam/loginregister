package com.habiburrohman.bizzhub.model;

public class Person {
    private String fullname;
    private String username;
    private String email;
    private String bdate;
    private String gender;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(String fullname, String username, String email, String bdate, String gender) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.bdate = bdate;
        this.gender = gender;
    }
}
