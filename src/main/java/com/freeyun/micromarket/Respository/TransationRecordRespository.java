package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.TRMultikey;
import com.freeyun.micromarket.Domain.TransationRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TransationRecordRespository extends JpaRepository<TransationRecord,TRMultikey> {
    Page<TransationRecord> findByUidIgnoreCase(String uid,Pageable pageable);
    Page<TransationRecord> findByCidIgnoreCase(String cid,Pageable pageable);
    Page<TransationRecord> findByTranstime(Date time,Pageable pageable);
    Page<TransationRecord> findByTransstatus(Integer status,Pageable pageable);
    Page<TransationRecord> findByMoney(Integer Money,Pageable pageable);
}
