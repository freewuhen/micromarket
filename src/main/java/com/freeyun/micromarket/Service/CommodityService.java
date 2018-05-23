package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Respository.CommodityResitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommodityService {
    @Autowired private CommodityResitory commodityResitory;
    private Integer size = 10;
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
    public Page<Commodity> getCommodityByCondition(Integer condition,Integer page,String name,Sort sort)
    {
        name = "%"+name+"%";//
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Commodity> commodities = null;
        switch (condition){
            case 1:
                commodities = commodityResitory.findByCategory(name,pageable);
                break;
            case 2:
                commodities = commodityResitory.findByBrands(name,pageable);
                break;
            case 3:
                commodities = commodityResitory.findBySupplier(name,pageable);
                break;
        }
        return commodities;
    }
//    public Page<Commodity> getCommodityByBname(String bname,Integer page,Sort sort)
//    {
//        bname = "%"+bname+"%";
//        //Sort sort = new Sort(Sort.Direction.ASC,"cname");
//        Pageable pageable = PageRequest.of(page,size,sort);
//        Page<Commodity> commodities = commodityResitory.findByBrands(bname,pageable);
//        return commodities;
//    }
//    public Page<Commodity> getCommodityBySname(String sname,Integer page,Sort sort)
//    {
//        sname = "%"+sname+"%";
//        //Sort sort = new Sort(Sort.Direction.ASC,"cname");
//        Pageable pageable = PageRequest.of(page,size,sort);
//        Page<Commodity> commodities = commodityResitory.findBySupplier(sname,pageable);
//        return commodities;
//    }

}
