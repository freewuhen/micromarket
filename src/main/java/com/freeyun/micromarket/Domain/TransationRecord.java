package com.freeyun.micromarket.Domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TransationRecord {
    @Id @Column(length = 20) private String tid;
    @Temporal(TemporalType.TIMESTAMP) private Date transtime;//交易时间
    private Integer transstatus;//交易状态
    private Float money;//交易金额
    private Integer transnumber;//Number of transactions
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "user_id") private User user;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "commodity_id") private Commodity commodity;

    public TransationRecord(){

    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Date getTranstime() {
        return transtime;
    }

    public void setTranstime(Date transtime) {
        this.transtime = transtime;
    }

    public Integer getTransstatus() {
        return transstatus;
    }

    public void setTransstatus(Integer transstatus) {
        this.transstatus = transstatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getTransnumber() {
        return transnumber;
    }

    public void setTransnumber(Integer transnumber) {
        this.transnumber = transnumber;
    }


}
