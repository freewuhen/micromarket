package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    public Page<Supplier> getSupplierList(Integer page)
    {
        Page<Supplier> Supplieres = null;
        return Supplieres;
    }
    public int addSupplier(Supplier supplier)
    {
        int status = 1;
        return status;
    }
    public int updateSupplier(Supplier supplier)
    {
        int status = 1;
        return status;
    }
    public int deleteSupplier(Supplier supplier)
    {
        int status = 1;
        return status;
    }
    public Page<Supplier> getSupplierBySname(String sname,Pageable pageable)
    {
        Page<Supplier> Supplieres = null;
        return Supplieres;
    }
}
