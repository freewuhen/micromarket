package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.CommodityResitory;
import com.freeyun.micromarket.Respository.TransationRecordRespository;
import com.freeyun.micromarket.Respository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
@Service
public class TransationService {

    @Autowired private TransationRecordRespository transationRecordRespository;
    @Autowired private CommodityResitory commodityResitory;
    @Autowired private UserRespository userRespository;
    @Autowired private UserService userService;
    @Autowired CommodityService commodityService;
    private int size = 10;
    private Sort sort = new Sort(Sort.Direction.DESC,"transtime");
    private Logger logger = LoggerFactory.getLogger(TransationService.class);


    public Boolean existbyid(String tid) {
        TransationRecord transationRecord= null;
        try{
            transationRecord = transationRecordRespository.findById(tid).get();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
    public Page<TransationRecord> getTransationRecordList(Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findAll(pageable);
        return transationRecords;
    }
    public TransationRecord getTraBytid(String tid)
    {
        TransationRecord transationRecord = null;
       try {
           transationRecord = transationRecordRespository.findById(tid).get();
           return transationRecord;
       }catch (Exception e)
       {
           logger.error(e.getLocalizedMessage());
       }
       return transationRecord;
    }
    @Transactional
    public int addTransationRecord(TransationRecord transationRecord)
    {
        int status = 1;

        if(existbyid(transationRecord.getTid()) == false) // if the TransationRecord doesn't exist
        {
            try {
                transationRecordRespository.save(transationRecord);
                commodityService.purchaseCom(transationRecord.getCommodity().getCid());
            }catch (Exception e)
            {
                status = 0;
            }

        }
        else
        {
            status = -1;
        }
        return status;


    }
    public int updateTransationRecord(TransationRecord transationRecord)
    {
        int status = 1;

        if(existbyid(transationRecord.getTid())) // if the TransationRecord already exists
        {
            try {
                transationRecordRespository.save(transationRecord);
            }catch (Exception e)
            {
                status = 0;
            }

        }
        else
        {
            status = -1;
        }
        return status;
    }

    public int deleteTransationRecord(TransationRecord transationRecord)
    {
        int status = 1;

        if(existbyid(transationRecord.getTid())) // if the TransationRecord already exists
        {
            try {
                transationRecordRespository.delete(transationRecord);
            }catch (Exception e)
            {
                status = 0;
            }

        }
        else
        {
            status = -1;
        }
        return status;
    }
    public int deleteTransationRecordByUser(User user)
    {
        if (userService.existbyid(user.getUid()))
        {
            try {

                transationRecordRespository.deleteAllByUser(user);
                return 1;
            }catch (Exception e)
            {
                return  0;
            }
        }
        return -1;
    }
    public int deleteTransationRecordByCom(Commodity commodity)
    {
        if (commodityService.existbyid(commodity.getCid()))
        {
            try {

                transationRecordRespository.deleteAllByCommodity(commodity);
                return 1;//ok
            }catch (Exception e)
            {
                return  0;//error
            }
        }
        return -1;// the Com doesn't exist
    }

    @Transactional
    public Page<TransationRecord> getTransationRecordByUser(String uid,Integer page)
    {
            User user = userRespository.findById(uid).get();
            Pageable pageable = PageRequest.of(page,size,sort);
            Page<TransationRecord> transationRecords= transationRecordRespository.findByUser(user,pageable);
            return transationRecords;
    }
    public Page<TransationRecord> getTransationRecordByCid(String cid,Integer page)
    {
        Commodity commodity = commodityResitory.findById(cid).get();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByCidIgnoreCase(commodity,pageable);
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
        User user = userRespository.findById(uid).get();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTransstatusAndUser(transstatus,user,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTrBystatusAndCom(Integer transstatus,String cid,Integer page)
    {
        Commodity commodity = commodityResitory.findById(cid).get();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTransstatusAndCommodity(transstatus,commodity,pageable);
        return transationRecords;
    }
    public Page<TransationRecord> getTrBystatus(Integer transstatus, Integer page)
    {
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<TransationRecord> transationRecords = transationRecordRespository.findByTransstatus(transstatus,pageable);
        return transationRecords;
    }

    @Transactional
    public int pay(String tid)
    {
        try {
            TransationRecord transationRecord = getTraBytid(tid);
            commodityService.purchaseCom(transationRecord.getCommodity().getCid());
            transationRecord.setTransstatus(1);
            addTransationRecord(transationRecord);
            return 1;
        }catch (Exception e)
        {
            logger.error(e.getLocalizedMessage());
            return  0;
        }

    }



}
