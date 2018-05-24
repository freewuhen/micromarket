package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.TransationRecordRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Date;
@Service
public class TransationService {
    @Autowired private TransationRecordRespository transationRecordRespository;
    private int size = 10;
    private Sort sort = new Sort(Sort.Direction.DESC,"transtime");

    public Page<TransationRecord> getTransationRecordList(Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findAll(pageable);
        return transationRecords;
    }
    public int addTransationRecord(TransationRecord transationRecord)
    {
        int status = 1;
        try {
            transationRecordRespository.save(transationRecord);

        }catch (Exception e)
        {
            status = 0;
        }
        return status;

    }
    public int updateTransationRecord(TransationRecord transationRecord)
    {
        int status = 1;
        return status;
    }
    public int deleteTransationRecord(TransationRecord transationRecord)
    {
        int status = 1;
        return status;
    }
    public Page<TransationRecord> getTransationRecordByUid(String uid,Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByUidIgnoreCase(uid,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTransationRecordByCid(String cid,Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByCidIgnoreCase(cid,pageable);
        return transationRecords;
    }


    public Page<TransationRecord> getAllTrByTime(String transtime, Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        transtime = "%"+transtime+"%";
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTranstime(transtime,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTrByTimeAndUser(String transtime,String uid,Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        transtime = "%"+transtime+"%";
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTranstimeAndUser(transtime,uid,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTrByTimeAndCom(String transtime,String cid,Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        transtime = "%"+transtime+"%";
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTranstimeAndCommodity(transtime,cid,pageable);
        return transationRecords;
    }


    public Page<TransationRecord> getTrBystatusAndUser(Integer transstatus,String uid,Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTransstatusAndUser(transstatus,uid,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTrBystatusAndCom(Integer transstatus,String cid,Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTransstatusAndCommodity(transstatus,cid,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTrBystatus(Integer transstatus, Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTransstatus(transstatus,pageable);
        return transationRecords;
    }




}
