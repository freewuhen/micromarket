package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.TransationRecordRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

public class TransationService {
    @Autowired private TransationRecordRespository transationRecordRespository;
    public Page<TransationRecord> getTransationRecordList(Integer page)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    public int addTransationRecord(TransationRecord TransationRecord)
    {
        int status = 1;
        return status;
    }
    public int updateTransationRecord(TransationRecord TransationRecord)
    {
        int status = 1;
        return status;
    }
    public int deleteTransationRecord(TransationRecord TransationRecord)
    {
        int status = 1;
        return status;
    }
    public Page<TransationRecord> getTransationRecordByUid(String uid,Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    public Page<TransationRecord> getTransationRecordByCid(String cid,Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    public Page<TransationRecord> getTrByTimeAndUse(Date transtime, User user, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    public Page<TransationRecord> getAllTrByTime(Date transtime, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    public Page<TransationRecord> getTrBystatus(Integer transstatus, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }
    public Page<TransationRecord> getTransationRecordByMoney(Integer money, Pageable pageable)
    {
        Page<TransationRecord> transationRecords = null;
        return transationRecords;
    }



}
