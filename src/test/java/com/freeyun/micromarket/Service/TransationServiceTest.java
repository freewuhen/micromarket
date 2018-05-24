package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.TransationRecord;
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
    @Test
    public void addTransationRecord() {
        LocalDateTime timepoint = LocalDateTime.now();
        System.out.print("\ntimepoint.getHour():"+timepoint.getHour()+"\n");
        Date date = Date.from(timepoint.atZone(ZoneId.systemDefault()).toInstant());
        System.out.print("\ndate.getHours()"+date.getHours()+"\n");
        int status = 0;
        TransationRecord transationRecord = new TransationRecord();
        transationRecord.setCid("010101");
        transationRecord.setUid("wuhen");
        transationRecord.setTransstatus(-1);
        transationRecord.setTranstime(date);
        transationRecord.setTransnumber(5);
        transationRecord.setMoney(Float.valueOf(20));
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