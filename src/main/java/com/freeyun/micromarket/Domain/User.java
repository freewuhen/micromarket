package com.freeyun.micromarket.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id @Column(length = 50) private String uid;
    @Column(length = 11) private String telenumber;
    @Column(length = 80) private String addr;
    private Float balence;//余额
    public User(){

    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getTelenumber() {
        return telenumber;
    }

    public void setTelenumber(String telenumber) {
        this.telenumber = telenumber;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Float getBalence() {
        return balence;
    }

    public void setBalence(Float balence) {
        this.balence = balence;
    }
}
