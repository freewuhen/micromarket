package com.freeyun.micromarket.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TRTicket  {
    @Id @Column(length = 30) private String trid;
    private float money;
    private Integer status;
    @ManyToOne private User user;
    @ManyToOne private Address address;


    public TRTicket()
    {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTrid() {
        return trid;
    }

    public void setTrid(String trid) {
        this.trid = trid;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
