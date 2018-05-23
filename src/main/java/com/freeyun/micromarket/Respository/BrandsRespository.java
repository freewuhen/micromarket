package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Brands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandsRespository extends JpaRepository<Brands,String> {
    @Query(value = "select * from brands where bname like ?1"
            ,countQuery = "select count(*) from brands where bname like ?1",nativeQuery = true)
    Page<Brands> findByBname(String bname,Pageable pageable);//需要完善,模糊查询
    Brands findByBname(String bname);
}
