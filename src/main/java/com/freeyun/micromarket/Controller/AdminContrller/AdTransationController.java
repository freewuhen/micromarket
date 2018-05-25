package com.freeyun.micromarket.Controller.AdminContrller;

import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Service.CommodityService;
import com.freeyun.micromarket.Service.TransationService;
import com.freeyun.micromarket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdTransationController {
    @Autowired TransationService transationService;
    @Autowired UserService userService;
    @Autowired CommodityService commodityService;
    @GetMapping("/getTransationRecordList")//admin
    public Object  getTransationRecordList(@RequestParam Integer page)
    {
        Page<TransationRecord> transationRecords = transationService.getTransationRecordList(page);
        return  transationRecords;
    }
    @GetMapping("/getTransationRecordByCid")// admin
    public Page<TransationRecord> getTransationRecordByCid(@RequestParam String cid, @RequestParam  Integer page)
    {
        if(commodityService.existbyid(cid))
        {
            Page<TransationRecord> transationRecords = transationService.getTransationRecordByCid(cid,page);
            return transationRecords;
        }

        else {
            return  null;
        }

    }
    @GetMapping("/getAllTrByTime") // admin
    public Object getAllTrByTime(@RequestParam String transtime ,@RequestParam int page )
    {
        Page<TransationRecord> transationRecords = transationService.getAllTrByTime(transtime,page);
        return transationRecords;
    }
    @GetMapping("/getTrByTimeAndCom")//admin
    public Object getTrByTimeAndcom(@RequestParam String transtime ,@RequestParam String cid ,@RequestParam int page )
    {
        if(commodityService.existbyid(cid)){
            Page<TransationRecord> transationRecords = transationService.getTrByTimeAndCom(transtime,cid,page);
            return transationRecords;
        }
        return null;

    }
    @GetMapping("/getTrBystatus")// admin
    public Object getTrBystatus(@RequestParam Integer status ,@RequestParam int page )
    {
        if(status != -2 && status != -1 && status != 0 && status != 1 && status != 2)
        {
            return  -1;
        }
        Page<TransationRecord> transationRecords = transationService.getTrBystatus(status,page);
        return transationRecords;
    }
    @GetMapping("/getTrBystatusAndCom")//admin
    public Object getTrBystatusAndCom(@RequestParam Integer status ,@RequestParam String cid ,@RequestParam int page )
    {
        if(status != -2 && status != -1 && status != 0 && status != 1 && status != 2)
        {
            return  -1;
        }
        if(commodityService.existbyid(cid)){
            Page<TransationRecord> transationRecords = transationService.getTrBystatusAndCom(status,cid,page);
            return transationRecords;
        }
        else  return  -2;

    }
}
