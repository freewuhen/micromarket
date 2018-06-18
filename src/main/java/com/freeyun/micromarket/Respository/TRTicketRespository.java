package com.freeyun.micromarket.Respository;

import com.freeyun.micromarket.Domain.TRTicket;
import com.freeyun.micromarket.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TRTicketRespository extends JpaRepository<TRTicket,String> {
        List<TRTicket> findDistinctByUser(User user);
}
