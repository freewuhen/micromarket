package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Address;
import com.freeyun.micromarket.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRespository extends JpaRepository<Address,Integer> {
    // 根据用户名查地址
    List<Address> findDistinctByUser(User user);
}
