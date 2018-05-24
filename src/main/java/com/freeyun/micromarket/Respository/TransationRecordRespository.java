package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.TRMultikey;
import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TransationRecordRespository extends JpaRepository<TransationRecord,TRMultikey> {
    @Query(value = "select tr from TransationRecord tr  where   tr.uid = ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.uid = ?1")
    Page<TransationRecord> findByUidIgnoreCase(String uid,Pageable pageable);
    @Query(value = "select tr from TransationRecord tr  where   tr.cid = ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.cid = ?1")
    Page<TransationRecord> findByCidIgnoreCase(String cid,Pageable pageable);



    @Query(value = "select tr from TransationRecord tr  where   tr.cid = ?2 and tr.transtime = ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.cid = ?2 and tr.transtime = ?1")
    Page<TransationRecord> findByTranstimeAndCommodity(String transtime,String cid,Pageable pageable);

    @Query(value = "select tr from TransationRecord tr  where   tr.uid = ?2 and tr.transtime = ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.uid = ?2 and tr.transtime = ?1")
    Page<TransationRecord> findByTranstimeAndUser(String transtime,String uid,Pageable pageable);

    @Query(value = "select tr from TransationRecord tr  where   tr.transtime like ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where  tr.transtime like ?1")
    Page<TransationRecord> findByTranstime(String transtime,Pageable pageable);



    @Query(value = "select tr from TransationRecord tr  where   tr.transstatus = ?1 and tr.uid = ?2"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.transstatus = ?1  and tr.uid = ?2")
    Page<TransationRecord> findByTransstatusAndUser(Integer status,String uid,Pageable pageable);

    @Query(value = "select tr from TransationRecord tr  where   tr.transstatus = ?1 and  tr.cid = ?2"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.transstatus = ?1 and  tr.cid = ?2")
    Page<TransationRecord> findByTransstatusAndCommodity(Integer status,String cid,Pageable pageable);

    @Query(value = "select tr from TransationRecord tr  where   tr.transstatus = ?1 "
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.transstatus = ?1 ")
    Page<TransationRecord> findByTransstatus(Integer status,Pageable pageable);

}
