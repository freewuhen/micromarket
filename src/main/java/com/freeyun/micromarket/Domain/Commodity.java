package com.freeyun.micromarket.Domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Commodity {//商品
    @Id @Column(length = 20) private String cid;
    @Column(length = 40) private String cname;
    private Integer costprice;//进价
    private Integer sellingprice;//售价
    private Integer stock_quantity;//库存数量
    private Integer Sales_volume;//销售数量
    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text") private String description;//商品商品描述
    @ManyToOne(cascade = CascadeType.ALL) private  Category category;//分类
    @ManyToOne(cascade = CascadeType.ALL) private Brands brands;//品牌
    @ManyToOne(cascade = CascadeType.ALL) private Supplier supplier;//供应商

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public Integer getCostprice() {
        return costprice;
    }

    public void setCostprice(Integer costprice) {
        this.costprice = costprice;
    }

    public Integer getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(Integer sellingprice) {
        this.sellingprice = sellingprice;
    }
}
