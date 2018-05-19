package com.freeyun.micromarket.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commodity {//商品
    @Id @Column(length = 20) private String cid;
    private String cname;
    private Integer price;//价格
    private Integer stock_quantity;//库存数量
    private Integer Sales_volume;//销售数量
    private String description;//商品商品描述
    public Commodity(){

    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Integer getSales_volume() {
        return Sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        Sales_volume = sales_volume;
    }
}
