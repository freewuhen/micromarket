package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceTest {
    @Autowired SupplierService supplierService;
    @Test
    public void getSupplierBySname() {
        Supplier supplier = new Supplier();
        String sname = "青岛可口可乐公司";
        String cinfo = "17865682502";
        int status = 0;
        supplier.setSname(sname);
        supplier.setContactinfo(cinfo);
        //supplier.setSid(id);

        status = supplierService.addSupplier(supplier);
        assertThat(status,equalTo(1));

//        supplier.setContactinfo("110");
//        status = supplierService.updateSupplier(supplier);
//        assertThat(status,equalTo(1));
//
//
//        status = supplierService.deleteSupplier(id);
//        assertThat(status,equalTo(1));
//
//        status = supplierService.deleteSupplier(id);
//        assertThat(status,equalTo(0));
//
//        status = supplierService.updateSupplier(supplier);
//        assertThat(status,equalTo(0));



    }
}