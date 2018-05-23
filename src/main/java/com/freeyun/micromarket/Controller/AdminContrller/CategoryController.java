package com.freeyun.micromarket.Controller.AdminContrller;

import com.freeyun.micromarket.Domain.Category;
import com.freeyun.micromarket.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired CategoryService categoryService;
    @GetMapping("/getCategoryList")
    public Page<Category> getCategoryList(@RequestParam  Integer page)
    {
        Page<Category> categories = categoryService.getCategoryList(page);
        return categories;
    }
}
