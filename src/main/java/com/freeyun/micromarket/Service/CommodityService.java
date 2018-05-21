package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Respository.CommodityResitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CommodityService {
    @Autowired private CommodityResitory commodityResitory;
    public Page<Commodity> getCommodityList(Integer page)
    {
        Page<Commodity> commodities = null;
        return commodities;
    }
    public int addCommodity(Commodity commodity)
    {
        int status = 1;
        return status;
    }
    public int updateCommodity(Commodity commodity)
    {
        int status = 1;
        return status;
    }
    public int deleteCommodity(Commodity commodity)
    {
        int status = 1;
        return status;
    }
    public Page<Commodity> getCommodityByCatename(String cname,Pageable pageable)
    {
        Page<Commodity> commodities = null;
        return commodities;
    }
    public Page<Commodity> getCommodityBname(String bname,Pageable pageable)
    {
        Page<Commodity> commodities = null;
        return commodities;
    }
}
