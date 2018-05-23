package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Commodity;
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
    @Test
    public void getCommodityByCatename() {
//        String cname = "饮";
//        Integer page = 0;
//        Page<Commodity> commodities = commodityService.getCommodityByCatename(cname,page);
//        assertThat(commodities.getSize(),equalTo(10));
    }
}