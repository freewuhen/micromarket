package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.CommodityResitory;
import com.freeyun.micromarket.Respository.UserRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransationServiceTest {
    @Autowired TransationService transationService;
    @Autowired UserRespository userRespository;
    @Autowired CommodityResitory commodityResitory;
    @Test
    public void addTransationRecord() {
        LocalDateTime timepoint = LocalDateTime.now();
        System.out.print("\ntimepoint.getHour():"+timepoint.getHour()+"\n");
        Date date = Date.from(timepoint.atZone(ZoneId.systemDefault()).toInstant());
        System.out.print("\ndate.getHours()"+date.getHours()+"\n");
        int status = 0;
        String tid = "20180525010101001001";
        String cid = "010101";
        String uid = "freeyun";
        User user = userRespository.findById(uid).get();
        Commodity commodity = commodityResitory.findById(cid).get();
        System.out.print("\ncommodity.getCname()"+commodity.getCname()+"\n");
        TransationRecord transationRecord = new TransationRecord();
        transationRecord.setTid(tid);
        transationRecord.setTransstatus(-1);
        transationRecord.setTranstime(date);
        transationRecord.setTransnumber(5);
        transationRecord.setMoney(Float.valueOf(20));
        transationRecord.setUser(user);
        transationRecord.setCommodity(commodity);

        status = transationService.addTransationRecord(transationRecord);
        assertThat(status,equalTo(1));

    }
    @Test
    public void findByTranstime() {
        String transtime = "2018";
        int page = 0;
        transationService.getAllTrByTime(transtime,page);
    }
}