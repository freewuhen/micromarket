package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Brands;
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
public class BrandsServiceTest {
    @Autowired private BrandsService brandsService;
    @Test
    public void getBrandsByBname() {
        Integer page = 0;
        String bname = "帅";
        int status = 0;
//        Page<Brands> brands = brandsService.getBrandsByBname(bname,page);
//        assertThat(brands.getSize(),equalTo(10));

        bname = "可口同乐";
        Brands brands1 = new Brands();
        brands1.setBid("010102");
        brands1.setBname(bname);

        status = brandsService.addBrands(brands1);
        assertThat(status,equalTo(1));

    }
}