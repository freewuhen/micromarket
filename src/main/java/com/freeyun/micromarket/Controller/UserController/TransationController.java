package com.freeyun.micromarket.Controller.UserController;

import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Service.CommodityService;
import com.freeyun.micromarket.Service.TransationService;
import com.freeyun.micromarket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransationController {
    @Autowired TransationService transationService;
    @Autowired UserService userService;
    @Autowired CommodityService commodityService;

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
