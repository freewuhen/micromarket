package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Brands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRespository extends JpaRepository<Brands,String> {
    Page<Brands> findByBname(String bname,Pageable pageable);//需要完善,模糊查询
}
