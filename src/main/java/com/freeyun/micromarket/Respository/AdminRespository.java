package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRespository extends JpaRepository<Admin,String> {
}
