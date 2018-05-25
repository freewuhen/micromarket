package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Brands;
import com.freeyun.micromarket.Respository.BrandsRespository;
import com.freeyun.micromarket.Respository.CommodityResitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BrandsService {
    @Autowired private BrandsRespository brandsRespository;
    @Autowired private CommodityResitory commodityResitory;
    private Logger logger  = LoggerFactory.getLogger(BrandsService.class);
    private int size = 10; //页面大小
    private Boolean existbyname(String bname){
        Brands testbrands = null;
        testbrands = brandsRespository.findByBname(bname);
        if(testbrands == null)
        {
            return false;
        }
        else
            return true;
    }
    private Boolean existbyid(String bid) {
        Brands testbrands = null;
        try{
            testbrands = brandsRespository.findById(bid).get();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
    public Page<Brands> getBrandsList(Integer page)
    {
        Sort sort = new Sort(Sort.Direction.ASC,"bid");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Brands> brands = brandsRespository.findAll(pageable);
        return brands;
    }
    public Brands getBrandsBybid(String bid){
        return brandsRespository.findById(bid).get();
    }
    public int addBrands(Brands brands)
    {
        int status = 0;
        if (existbyname(brands.getBname()) == false)// 分类不存在
        {
            brandsRespository.save(brands);
            status = 1;
        }
        return status;
    }
    public int updateBrands(Brands brands)
    {
        int status = 0;// brands doesn't exist
        if (existbyid(brands.getBid()))// Brands already exists
        {
            if (existbyname(brands.getBname()) == false)
            {
                brandsRespository.save(brands);
                status = 1;//update completed
            }
            else {
                status = -1;// Brands name already exists
            }
        }
        return status;
    }
    public int deleteBrands(String bid)
    {
        int status = 0;
        Brands brands;
        if (existbyid(bid))// 分类存在
        {
            brands = brandsRespository.findByBname(bid);
            commodityResitory.deleteAllByBrands(brands);
            brandsRespository.delete(brands);
            status = 1;
        }
        return status;
    }
    public Page<Brands> getBrandsByBname(String bname,Integer page)
    {
        bname = "%"+bname+"%";
        Sort sort = new Sort(Sort.Direction.ASC,"bid");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Brands> brands = brandsRespository.findByBname(bname,pageable);
        return brands;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
