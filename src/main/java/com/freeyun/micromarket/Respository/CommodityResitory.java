package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityResitory extends JpaRepository<Commodity,String> {
    Page<Commodity> findByCname(String cname,Pageable pageable);//需要完善,模糊查询
    Page<Commodity> findByBrands(String bname,Pageable pageable);//需要完善,模糊查询
}
