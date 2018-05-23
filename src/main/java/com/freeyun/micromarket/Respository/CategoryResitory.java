package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryResitory extends JpaRepository<Category,Integer> {
    Category findByCatename(String cname);
}
