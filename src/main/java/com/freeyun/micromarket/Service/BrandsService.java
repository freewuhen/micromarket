package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Brands;
import com.freeyun.micromarket.Respository.BrandsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BrandsService {
    @Autowired private BrandsRespository brandsRespository;
    public Page<Brands> getBrandsList(Integer page)
    {
        Page<Brands> brands = null;
        return brands;
    }
    public int addBrands(Brands brands)
    {
        int status = 1;
        return status;
    }
    public int updateBrands(Brands brands)
    {
        int status = 1;
        return status;
    }
    public int deleteBrands(Brands brands)
    {
        int status = 1;
        return status;
    }
    public Page<Brands> getBrandsByBname(String bname,Pageable pageable)
    {
        Page<Brands> brands = null;
        return brands;
    }
}
