package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Category;
import com.freeyun.micromarket.Respository.CategoryResitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Service
public class CategoryService {
    @Autowired private CategoryResitory categoryResitory;
    public Page<Category> getCategoryList(Integer page)
    {
        Page<Category> categories = null;
        return categories;
    }
    public int addCategory(Category category)
    {
        int status = 1;
        return status;
    }
    public int updateCategory(Category category)
    {
        int status = 1;
        return status;
    }
    public int deleteCategory(Category category)
    {
        int status = 1;
        return status;
    }
    public Page<Category> getCategoryByCatename(String catename,Pageable pageable)
    {
        Page<Category> categories = null;
        return categories;
    }

}
