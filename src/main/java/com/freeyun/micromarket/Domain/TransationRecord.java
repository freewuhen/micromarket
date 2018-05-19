package com.freeyun.micromarket.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(TRMultikey.class)
public class TransationRecord {
    @Id @Column(name = "user_id",length = 20) private String uid;
    @Id @Column(name = "commodity_id",length = 20) private String cid;
    private Date transtime;//交易时间
    private Integer transstatus;//交易状态
    private Integer money;//交易金额

    @ManyToOne @JoinColumn(name = "user_id",insertable = false, updatable = false) private User user;
    @ManyToOne @JoinColumn(name = "commodity_id",insertable = false, updatable = false)private Commodity commodity;

    public TransationRecord(){

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
