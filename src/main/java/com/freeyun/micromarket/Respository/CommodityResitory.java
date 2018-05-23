package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Brands;
import com.freeyun.micromarket.Domain.Category;
import com.freeyun.micromarket.Domain.Commodity;
import com.freeyun.micromarket.Domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommodityResitory extends JpaRepository<Commodity,String> {

    @Query(value = "select * from commodity where cname like ?1"
            ,countQuery = "select count(*) from commodity where cname like ?1",nativeQuery = true)
    Page<Commodity> findByCname(String cname,Pageable pageable);//需要完善,模糊查询

    @Query(value = "select com from Commodity com,Category cate where com.category = cate.cateid and cate.catename like ?1"
            ,countQuery = "select count(com) from Commodity com,Category cate where com.category.cateid = cate.cateid and cate.catename like ?1")
    Page<Commodity> findByCategory(String cname,Pageable pageable);//需要完善,模糊查询

    @Query(value = "select com from Commodity com,Brands bran  where com.brands = bran.bid and bran.bname like ?1"
            ,countQuery = "select count(com) from Commodity com,Brands bran  where com.brands = bran.bid and bran.bname like ?1")
    Page<Commodity> findByBrands(String bname,Pageable pageable);//需要完善,模糊查询

    @Query(value = "select com from Commodity com,Supplier sup  where com.supplier = sup.sid and sup.sname like ?1"
            ,countQuery = "select count(com) from Commodity com,Supplier sup  where com.supplier = sup.sid and sup.sname like ?1")
    Page<Commodity> findBySupplier(String sname,Pageable pageable);//需要完善,模糊查询
    void deleteAllBySupplier(Supplier supplier);
    void deleteAllByBrands(Brands brands);
    void deleteAllByCategory(Category category);


}
