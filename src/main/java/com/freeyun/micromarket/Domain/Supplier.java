package com.freeyun.micromarket.Domain;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer sid;
    @Column(length = 60) private String sname;
    @Column(length = 30) private String contactinfo;

    public Supplier(){}

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }
}
