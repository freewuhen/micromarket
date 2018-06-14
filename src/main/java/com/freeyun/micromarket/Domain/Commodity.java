package com.freeyun.micromarket.Domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Commodity {//商品
    @Id @Column(length = 20) private String cid;
    @Column(length = 40) private String cname;
    private Float costprice;//进价
    private Float sellingprice;//售价
    private Integer stock_quantity;//库存数量
    private Integer sales_volume;//销售数量
    private Float score;//评分
    private Integer nopps;//Number of people participating in the score
    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text") private String description;//商品商品描述
    private @Column(length = 100)String bimage;//大图片的地址
    private @Column(length = 100) String simage;//小图片的地址

    @ManyToOne() private  Category category;//分类
    @ManyToOne() private Brands brands;//品牌
    @ManyToOne() private Supplier supplier;//供应商

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

    public String getBimage() {
        return bimage;
    }

    public void setBimage(String bimage) {
        this.bimage = bimage;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getCostprice() {
        return costprice;
    }

    public void setCostprice(Float costprice) {
        this.costprice = costprice;
    }

    public Float getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(Float sellingprice) {
        this.sellingprice = sellingprice;
    }

    public Integer getNopps() {
        return nopps;
    }

    public void setNopps(Integer nopps) {
        this.nopps = nopps;
    }
}
