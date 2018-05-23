package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRespository extends JpaRepository<Supplier,Integer> {
    @Query(value = "select * from supplier where sname like ?1"
            ,countQuery = "select count(*) from supplier where sname like ?1",nativeQuery = true)
    Page<Supplier> findBySname(String sname, Pageable pageable);//需要完善,模糊查询
    Supplier findBySname(String sname);
}
