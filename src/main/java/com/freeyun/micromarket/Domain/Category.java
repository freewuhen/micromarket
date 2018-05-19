package com.freeyun.micromarket.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Category {
    @Id private Integer cateid;//类别号
    private String catename;//类别名
    private Integer amount;//类别下数量
    public Category(){

    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
