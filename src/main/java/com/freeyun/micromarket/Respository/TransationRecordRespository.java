package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.TRMultikey;
import com.freeyun.micromarket.Domain.TransationRecord;
import com.freeyun.micromarket.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TransationRecordRespository extends JpaRepository<TransationRecord,String> {
    @Query(value = "select tr from TransationRecord tr  where   tr.user = ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.user = ?1")
    Page<TransationRecord> findByUser(User user,Pageable pageable);
    @Query(value = "select tr from TransationRecord tr  where   tr.commodity = ?1"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.commodity = ?1")
    Page<TransationRecord> findByCidIgnoreCase(Commodity commodity, Pageable pageable);



    @Query(value = "select * from transation_record where transtime like ?1 and commodity_id = ?2"
            ,countQuery = "select count(*)  transation_record where transtime like ?1 and commodity_id = ?2",nativeQuery = true)
    Page<TransationRecord> findByTranstimeAndCommodity(String transtime,String cid,Pageable pageable);

    @Query(value = "select * from transation_record where transtime like ?1 and user_id = ?2"
            ,countQuery = "select count(*)  transation_record where transtime like ?1 and user_id = ?2",nativeQuery = true)
    Page<TransationRecord> findByTranstimeAndUser(String transtime,String uid,Pageable pageable);

    @Query(value = "select * from transation_record where transtime like ?1"
            ,countQuery = "select count(*) from transation_record where transtime like ?1",nativeQuery = true)
    Page<TransationRecord> findByTranstime(String transtime,Pageable pageable);



    @Query(value = "select tr from TransationRecord tr  where   tr.transstatus = ?1 and tr.user = ?2"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.transstatus = ?1  and tr.user = ?2")
    Page<TransationRecord> findByTransstatusAndUser(Integer status,User user,Pageable pageable);

    @Query(value = "select tr from TransationRecord tr  where   tr.transstatus = ?1 and  tr.commodity = ?2"
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.transstatus = ?1 and  tr.commodity = ?2")
    Page<TransationRecord> findByTransstatusAndCommodity(Integer status,Commodity commodity,Pageable pageable);

    @Query(value = "select tr from TransationRecord tr  where   tr.transstatus = ?1 "
            ,countQuery = "select count(tr)  from TransationRecord tr  where   tr.transstatus = ?1 ")
    Page<TransationRecord> findByTransstatus(Integer status,Pageable pageable);

    void deleteAllByUser(User user);

    void deleteAllByCommodity(Commodity commodity);




}
