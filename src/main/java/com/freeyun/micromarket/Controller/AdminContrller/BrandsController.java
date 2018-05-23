package com.freeyun.micromarket.Controller.AdminContrller;

import com.freeyun.micromarket.Domain.Brands;
import com.freeyun.micromarket.Service.BrandsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandsController {
    @Autowired BrandsService brandsService;
    private Logger logger  = LoggerFactory.getLogger(BrandsController.class);
    @GetMapping("/getBrandsByBname")
    public Page<Brands> getBrandsByBname(@RequestParam Integer page,@RequestParam String bname)
    {
        logger.error("bname:"+bname);
        Page<Brands> brands= brandsService.getBrandsByBname(bname,page);
        return brands;
    }
}
