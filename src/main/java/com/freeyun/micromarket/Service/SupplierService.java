package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Supplier;
import com.freeyun.micromarket.Respository.CommodityResitory;
import com.freeyun.micromarket.Respository.SupplierRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired private SupplierRespository supplierRespository;
    @Autowired private CommodityResitory commodityResitory;
    private Logger logger  = LoggerFactory.getLogger(SupplierService.class);
    private int size = 10; //page size
    private Boolean existbyid(Integer id) {

        Supplier testsup = null;
        try{
            testsup = supplierRespository.findById(id).get();
            return true;
        }catch (Exception e)
        {
           return false;
        }

    }
    private Boolean existbyname(String sname) {
        Supplier testsup = null;
        testsup = supplierRespository.findBySname(sname);
        if (testsup == null) {
            return false;
        } else return true;
    }
    public Page<Supplier> getSupplierList(Integer page)
    {
        Sort sort = new Sort(Sort.Direction.ASC,"sid");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Supplier> Supplieres = supplierRespository.findAll(pageable);
        return Supplieres;
    }
    public int addSupplier(Supplier supplier)
    {
        int status = 0;
        if (existbyname(supplier.getSname()) == false)// 供应商不存在
        {
           supplierRespository.save(supplier);
            status = 1;
        }

        return status;
    }
    public int updateSupplier(Supplier supplier)
    {
        int status = 0; // supplier doesn't exist
        if (existbyid(supplier.getSid()))// supplier already exists
        {
            if (existbyname(supplier.getSname())==false)
            {
                supplierRespository.save(supplier);
                status = 1;// update completed
            }
            else {
                status = -1; // supname already exists
            }

        }

        return status;
    }
    public Supplier getSupBysid(Integer sid){
        return supplierRespository.findById(sid).get();
    }
    public int deleteSupplier(Integer sid)
    {
        int status = 0;
        Supplier supplier;
        if (existbyid(sid))// 供应商存在
        {
            supplier = supplierRespository.findById(sid).get();
            commodityResitory.deleteAllBySupplier(supplier);//级联操作
            supplierRespository.delete(supplier);
            status = 1;
        }
        return status;
    }
    public Page<Supplier> getSupplierBySname(String sname,Integer page)
    {
        sname = "%"+sname+"%";
        Sort sort = new Sort(Sort.Direction.ASC,"sname");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Supplier> Supplieres = supplierRespository.findBySname(sname,pageable);
        return Supplieres;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
