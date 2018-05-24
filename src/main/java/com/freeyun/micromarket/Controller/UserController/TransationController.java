package com.freeyun.micromarket.Controller.UserController;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.CommodityResitory;
import com.freeyun.micromarket.Respository.UserRespository;
import com.freeyun.micromarket.Service.TransationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransationController {
    @Autowired TransationService transationService;
    @Autowired UserRespository userRespository;
    @Autowired CommodityResitory commodityResitory;
    @GetMapping("/getTransationRecordList")//admin
    public Object  getTransationRecordList(@RequestParam Integer page)
    {
        Page<TransationRecord> transationRecords = transationService.getTransationRecordList(page);
        return  transationRecords;
    }
    @GetMapping("/getTransationRecordByUid")
    public Object getTransationRecordByUid(@RequestParam String uid, @RequestParam  Integer page)
    {
        User user = null;
        try {
            user = userRespository.findById(uid).get();
            Page<TransationRecord> transationRecords = transationService.getTransationRecordByUid(uid,page);
            return transationRecords;
        }catch (Exception e)
        {
            return 0;
        }

    }
    @GetMapping("/getTransationRecordByCid")// admin
    public Object getTransationRecordByCid(@RequestParam String cid, @RequestParam  Integer page)
    {
        Commodity commodity = null;
        try {
            commodityResitory.findById(cid).get();
            Page<TransationRecord> transationRecords = transationService.getTransationRecordByCid(cid,page);
            return transationRecords;
        }catch (Exception e)
        {
            return 0;
        }

    }



    @GetMapping("/getAllTrByTime") // admin
    public Object getAllTrByTime(@RequestParam String transtime ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getAllTrByTime(transtime,page);
        return transationRecords;
    }
    @GetMapping("/getTrByTimeAndUser")
    public Object getTrByTimeAndUser(@RequestParam String transtime ,@RequestParam String uid ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getTrByTimeAndUser(transtime,uid,page);
        return transationRecords;
    }
    @GetMapping("/getTrByTimeAndCom")
    public Object getTrByTimeAndcom(@RequestParam String transtime ,@RequestParam String cid ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getTrByTimeAndCom(transtime,cid,page);
        return transationRecords;
    }




    @GetMapping("/getTrBystatus")
    public Object getTrBystatus(@RequestParam Integer status ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getTrBystatus(status,page);
        return transationRecords;
    }
    @GetMapping("/getTrBystatusAndUser")
    public Object getTrBystatusAndUser(@RequestParam Integer status ,@RequestParam String uid ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getTrBystatusAndUser(status,uid,page);
        return transationRecords;
    }
    @GetMapping("/getTrBystatusAndCom")
    public Object getTrBystatusAndCom(@RequestParam Integer status ,@RequestParam String cid ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getTrBystatusAndCom(status,cid,page);
        return transationRecords;
    }





}
