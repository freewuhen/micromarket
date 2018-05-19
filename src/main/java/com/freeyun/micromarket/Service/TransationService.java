package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Respository.TransationRecordRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

public class TransationService {
    @Autowired private TransationRecordRespository transationRecordRespository;
    @GetMapping("/getTransationRecordList")
    public Page<TransationRecord> getTransationRecordList(Integer page)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    @PostMapping("/addTransationRecord")
    public int addTransationRecord(TransationRecord TransationRecord)
    {
        int status = 1;
        return status;
    }
    @PostMapping("/updateTransationRecord")
    public int updateTransationRecord(TransationRecord TransationRecord)
    {
        int status = 1;
        return status;
    }
    @PostMapping("/deleteTransationRecord")
    public int deleteTransationRecord(TransationRecord TransationRecord)
    {
        int status = 1;
        return status;
    }
    @GetMapping("/getTransationRecordByUid")
    public Page<TransationRecord> getTransationRecordByUid(String uid,Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    @GetMapping("/getTransationRecordByCid")
    public Page<TransationRecord> getTransationRecordByCid(String cid,Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    @GetMapping("/getTransationRecordByTranstime")
    public Page<TransationRecord> getTransationRecordByTranstime(Date transtime, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    @GetMapping("/getTransationRecordByTransstatus")
    public Page<TransationRecord> getTransationRecordByTransstatus(Integer transstatus, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    @GetMapping("/getTransationRecordByMoney")
    public Page<TransationRecord> getTransationRecordByMoney(Integer money, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }



}
