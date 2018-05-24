package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired CategoryService categoryService;
    private Logger logger = LoggerFactory.getLogger(CategoryServiceTest.class);
    @Test
    public void addCategory() {
        int status = 0;
        Category category = new Category();
        category.setCatename("饮料");
        category.setAmount(0);
        status = categoryService.addCategory(category);
        assertThat(status,equalTo(1));

//        Integer page = 0;
//        Page<Category> categories = categoryService.getCategoryList(page);
//
//        logger.error("categories.toString():"+categories.toString());
//        assertThat(categories.getSize(),equalTo(10));
//
//        category.setCateid(9);
//        category.setAmount(1);
//        category.setCatename("日用品");
//        status = categoryService.updateCategory(category);
//        assertThat(status,equalTo(1));





    }

}