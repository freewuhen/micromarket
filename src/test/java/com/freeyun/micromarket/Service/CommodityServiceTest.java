package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Brands;
import com.freeyun.micromarket.Domain.Category;
import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceTest {
    @Autowired private CommodityService commodityService;
    @Autowired private CategoryService categoryService;
    @Autowired private BrandsService brandsService;
    @Autowired private SupplierService supplierService;
    @Test
    public void getCommodityByCatename() {
        int status = 0;
        Commodity commodity = commodityService.getComByCid("010103");
//
//        Category category = categoryService.getCateByCid(1);
//        Brands brands = brandsService.getBrandsBybid("010102");
//        Supplier supplier = supplierService.getSupBysid(1);
//        Commodity commodity = new Commodity();
//        String id = "010103";
//        String name = "绿茶550ml";
//
//
//        commodity.setSupplier(supplier);
//        commodity.setBrands(brands);
//        commodity.setCategory(category);
//        commodity.setCid(id);
//        commodity.setCname(name);
//        commodity.setScore(Float.valueOf(0));
//        commodity.setStock_quantity(100);
//        commodity.setSales_volume(0);
//        commodity.setNopps(0);
//        commodity.setCostprice(Float.valueOf(3));
//        commodity.setSellingprice(Float.valueOf(4));
//
//        status = commodityService.addCommodity(commodity);
//        assertThat(status,equalTo(1));
//
//        commodity.setDescription("实惠");
//        status = commodityService.updateCommodity(commodity);
//        assertThat(status,equalTo(1));
//
//        commodity = commodityService.getComByCid(id);
//        assertThat(commodity.getCname(),equalTo(name));

     //

    }
}