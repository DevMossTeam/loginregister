package com.habiburrohman.bizzhub.model;

public class Person {
    private String fullname;
    private String username;
    private String email;
    private String bdate;
    private String gender;
    private String nohp;
    private String alamat;
    private String password;

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

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(String fullname, String username, String email, String bdate, String gender, String nohp, String alamat, String password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.bdate = bdate;
        this.gender = gender;
        this.nohp = nohp;
        this.alamat = alamat;
        this.password = password;

    }
}
