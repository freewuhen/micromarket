package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Category;
import com.freeyun.micromarket.Respository.CategoryResitory;
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
public class CategoryService {
    @Autowired private CategoryResitory categoryResitory;
    @Autowired private CommodityResitory commodityResitory;
    private Logger logger  = LoggerFactory.getLogger(CategoryService.class);
    private int size = 10; //页面大小
    private Boolean existbyname(String cname){
        Category testcate = null;
        testcate = categoryResitory.findByCatename(cname);
        if(testcate == null)
        {
            return false;
        }
        else
            return true;
    }
    private Boolean existbyid(Integer cid) {
        Category testcate = null;
        try{
            testcate = categoryResitory.findById(cid).get();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
    public Page<Category> getCategoryList(Integer page)
    {
        Sort sort = new Sort(Sort.Direction.ASC,"cateid");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Category> categories = categoryResitory.findAll(pageable);
        return categories;
    }

    public Category getCateByCid(Integer cateid)
    {
        return categoryResitory.findById(cateid).get();
    }
    public int addCategory(Category category)
    {
        int status = 0;
        if (existbyname(category.getCatename()) == false)// 分类不存在
        {
            categoryResitory.save(category);
            status = 1;
        }
        return status;
    }
    public int updateCategory(Category category)
    {
        int status = 0;// Category doesn't exist
        if (existbyid(category.getCateid()))//Category already exists
        {
            if (existbyname(category.getCatename()) == false)
            {
                categoryResitory.save(category);
                status = 1;//update completed
            }
            else {
                status = -1;// Catename already exists
            }
        }
        return status;
    }
    public int deleteCategory(Integer cateid)
    {
        int status = 0;
        if (existbyid(cateid))// 分类存在
        {
            Category category = categoryResitory.findById(cateid).get();
            commodityResitory.deleteAllByCategory(category);
            categoryResitory.delete(category);
            status = 1;
        }
        return status;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
