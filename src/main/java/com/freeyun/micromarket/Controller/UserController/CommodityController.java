package com.freeyun.micromarket.Controller.UserController;

import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityController {
    @Autowired private CommodityService commodityService;
    private String[] conditions = {"sellingprice","sales_volume","score"};
    private Sort.Direction[] directions = {Sort.Direction.ASC,Sort.Direction.DESC};
    private Object getCommodityBy(Integer qcondition,Integer page, String catename,Integer condno,Integer dirno)
    {
        if(dirno >= directions.length || condno >= conditions.length)
            return 0;
        Sort.Direction direction = directions[dirno];
        String condtion = conditions[condno];
        Sort sort = new Sort(direction,condtion);
        Page<Commodity> commodities = commodityService.getCommodityByCondition(qcondition,page,catename,sort);
        return  commodities;
    }
    @GetMapping("/getCommodityByCatename")
    public Object getCommodityByCatename(@RequestParam Integer page,@RequestParam String catename,@RequestParam Integer condno,@RequestParam Integer dirno){
        return getCommodityBy(1,page,catename,condno,dirno);
    }
    @GetMapping("/getCommodityByBname")
    public Object getCommodityByBname(@RequestParam Integer page,@RequestParam String bname,@RequestParam Integer condno,@RequestParam Integer dirno){
        return getCommodityBy(2,page,bname,condno,dirno);
    }
    @GetMapping("/getCommodityBySname")
    public Object getCommodityBySname(@RequestParam Integer page,@RequestParam String sname,@RequestParam Integer condno,@RequestParam Integer dirno){
        return getCommodityBy(3,page,sname,condno,dirno);
    }



}