package com.freeyun.micromarket.Controller.UserController;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.CommodityResitory;
import com.freeyun.micromarket.Respository.UserRespository;
import com.freeyun.micromarket.Service.CommodityService;
import com.freeyun.micromarket.Service.TransationService;
import com.freeyun.micromarket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TransationController {
    @Autowired TransationService transationService;
    @Autowired UserService userService;
    @Autowired CommodityService commodityService;
    @Autowired UserRespository userRespository;
    @Autowired CommodityResitory commodityResitory;

    @PostMapping("addTransationRecord")
    public int addTransationRecord(@RequestParam String tid,@RequestParam String uid,@RequestParam String cid,@RequestParam Float money,@RequestParam Integer num,@RequestParam Integer status,@RequestParam long time)
    {
        TransationRecord transationRecord = new TransationRecord();
        User user = userRespository.findById(uid).get();
        Commodity commodity = commodityResitory.findById(cid).get();
        transationRecord.setTid(tid);
        transationRecord.setTransstatus(status);
        transationRecord.setTransnumber(num);
        transationRecord.setMoney(money);
        transationRecord.setUser(user);
        transationRecord.setCommodity(commodity);
        transationRecord.setTranstime(new Date(time));
        return transationService.addTransationRecord(transationRecord);
    }
    @GetMapping("/getTransationRecordByUid")
    public Page<TransationRecord> getTransationRecordByUid(@RequestParam String uid, @RequestParam  Integer page)
    {
        if(userService.existbyid(uid))
        {
            Page<TransationRecord> transationRecords = transationService.getTransationRecordByUser(uid,page);
            return transationRecords;
        }
        else {
            return null;
        }

    }

    @GetMapping("/getTrByTimeAndUser")
    public Page<TransationRecord> getTrByTimeAndUser(@RequestParam String transtime ,@RequestParam String uid ,@RequestParam int page )
    {
        if (userService.existbyid(uid))
        {
            Page<TransationRecord> transationRecords = transationService.getTrByTimeAndUser(transtime,uid,page);
            return transationRecords;
        }
        else return null;

    }

    @GetMapping("/getTrBystatusAndUser")
    public Object getTrBystatusAndUser(@RequestParam Integer status ,@RequestParam String uid ,@RequestParam int page )
    {
        if(status != -2 && status != -1 && status != 0 && status != 1 && status != 2)
        {
            return  -1;
        }
        if (userService.existbyid(uid)){
            Page<TransationRecord> transationRecords = transationService.getTrBystatusAndUser(status,uid,page);
            return transationRecords;
        }
        else return -2;

    }

    @PostMapping("/pay")
    public int pay(@RequestParam String tid){
        TransationRecord transationRecord;
        int status = 0;
        if (transationService.existbyid(tid))
        {
            status = transationService.pay(tid);
        }
        return status;
    }








}
