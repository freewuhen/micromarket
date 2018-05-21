package com.freeyun.micromarket.Domain;

import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brands {
    @Id @Column(length = 15) private String bid;
    @Column(length = 40) private String bname;

    public Brands(){}

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
