package com.freeyun.micromarket.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id private String Aid;
    private String password;
    public Admin(){

    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
