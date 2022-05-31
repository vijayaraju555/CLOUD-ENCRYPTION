package com.cloudencryption.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "userreg")
public class User {
    @Id
    private int uid;
    private String uname;
    private String password;
    private String email;
    private String phone;
    private String gen;
    private String aname;

    public User() {
        //for not getting error
    }

    public User(String uname, String password, String email, String phone, String gen, String aname) {
        this.uname = uname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gen = gen;
        this.aname = aname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
