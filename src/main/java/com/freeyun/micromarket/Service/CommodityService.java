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
        name = "%"+name+"%";//Handing of fuzzy queries
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
    public int addComScore(String cid,Float score)
    {
        Float comscore;
        Integer nopps;
        Commodity commodity = null;
        try {
            commodity= commodityResitory.findById(cid).get();
            comscore = commodity.getScore();
            nopps = commodity.getNopps();
            comscore = (comscore*nopps+score)/(nopps+1);
            nopps++;
            commodity.setScore(comscore);
            commodity.setNopps(nopps);
            commodityResitory.save(commodity);
            return  1;
        }catch (Exception e)
        {
            return 0;
        }

    }
    public int purchaseCom(String cid)
    {
        Integer stock_quantity = 0,sales_volume = 0;
        Commodity commodity;
        try {
            commodity = commodityResitory.findById(cid).get();
            stock_quantity = commodity.getStock_quantity();
            sales_volume = commodity.getSales_volume();
            stock_quantity = stock_quantity-1;
            sales_volume = sales_volume + 1;
            if (stock_quantity < 1) return -1;// Commodity have been sold out
            commodity.setStock_quantity(stock_quantity);
            commodity.setSales_volume(sales_volume);
            commodityResitory.save(commodity);
            return 1;
        }catch (Exception e)
        {
          return 0;
        }

    }

}
