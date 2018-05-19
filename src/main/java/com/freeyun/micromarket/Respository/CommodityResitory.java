package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Category;
import com.freeyun.micromarket.Domain.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityResitory extends JpaRepository<Commodity,String> {
    Page<Category> findByCname(String cname,Pageable pageable);//需要完善,模糊查询
}
