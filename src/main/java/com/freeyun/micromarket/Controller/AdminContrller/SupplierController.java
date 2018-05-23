package com.freeyun.micromarket.Controller.AdminContrller;

import com.freeyun.micromarket.Domain.Supplier;
import com.freeyun.micromarket.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
    @Autowired SupplierService supplierService;
    @GetMapping("/getSupplierBySname")
    public Page<Supplier> getSupplierBySname(@RequestParam Integer page,@RequestParam String sname){
        Page<Supplier> suppliers = supplierService.getSupplierBySname(sname,page);
        return suppliers;
    }
}
