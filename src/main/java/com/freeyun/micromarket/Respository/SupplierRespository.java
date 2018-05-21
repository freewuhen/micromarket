package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplierRespository {
    Page<Supplier> findByCname(String cname, Pageable pageable);//需要完善,模糊查询
}
