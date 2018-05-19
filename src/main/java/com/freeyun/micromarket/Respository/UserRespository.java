package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,String> {
}
