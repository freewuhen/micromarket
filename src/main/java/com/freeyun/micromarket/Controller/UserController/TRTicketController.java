package com.freeyun.micromarket.Controller.UserController;

import com.freeyun.micromarket.Domain.Address;
import com.freeyun.micromarket.Domain.TRTicket;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Service.AddressService;
import com.freeyun.micromarket.Service.TRTicketService;
import com.freeyun.micromarket.Service.TransationService;
import com.freeyun.micromarket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TRTicketController {
    @Autowired private UserService userService;
    @Autowired private TransationService transationService;
    @Autowired private TRTicketService trTicketService;
    @Autowired private AddressService addressService;


    @GetMapping("/findTRTicketByUser")
    public Object findTRTicketByUser(@RequestParam String uid)
    {
        User user = userService.getUserById(uid);
        return trTicketService.findTRTicketByUser(user);
    }

    @GetMapping("/findTRTicketByAid")
    public
    Object findTRTicketByAid(@RequestParam String trid)
    {
        return  trTicketService.getTicketByid(trid);
    }
    @PostMapping("/addTRTicket")
    public int addTRTicketByUser(@RequestParam String trid ,@RequestParam String uid,@RequestParam Integer aid,@RequestParam float money,@RequestParam Integer status)
    {
        User user = userService.getUserById(uid);
        Address address = addressService.getAdByid(aid);
        TRTicket ticket = new TRTicket();
        ticket.setTrid(trid);
        ticket.setAddress(address);
        ticket.setUser(user);
        ticket.setMoney(money);
        ticket.setStatus(status);
        return trTicketService.addTRTicket(ticket);
    }
    @PostMapping ("/updateTRTicketMoney")
    public int updateTRTicketMoney(@RequestParam String trid,@RequestParam float money)
    {


        TRTicket ticket = trTicketService.getTicketByid(trid);
        if(ticket == null) return -2;
        ticket.setMoney(ticket.getMoney()+money);
        return trTicketService.updateTRTicket(ticket);

    }
    @PostMapping ("/updateTRTicketStatus")
    public int updateTRTicketStatus(@RequestParam String trid,@RequestParam Integer status)
    {

        TRTicket ticket = trTicketService.getTicketByid(trid);
        if(ticket == null) return -2;
        ticket.setStatus(status);
        return trTicketService.updateTRTicket(ticket);

    }
    @PostMapping ("/deleteTRTicket")
    public int deleteTRTicketByUser(@RequestParam String trid)
    {
        return trTicketService.deleteTRTicket(trid);
    }

}
