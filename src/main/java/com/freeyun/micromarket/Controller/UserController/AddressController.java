package com.freeyun.micromarket.Controller.UserController;

import com.freeyun.micromarket.Domain.Address;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Service.AddressService;
import com.freeyun.micromarket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired private AddressService addressService;
    @Autowired private UserService userService;

    @GetMapping("/findAddressByUser")
    public Object findAddressByUser(@RequestParam String uid)
    {
        User user = userService.getUserById(uid);
        return addressService.findAddressByUser(user);
    }

    @GetMapping("/findAddressByAid")
    public
    Object findAddressByAid(@RequestParam Integer aid)
    {
      return  addressService.getAdByid(aid);
    }
    @PostMapping ("/addAddress")
    public int findAddressByUser(@RequestParam String address ,@RequestParam String name,@RequestParam String tele,@RequestParam String uid)
    {
        User user = userService.getUserById(uid);
        Address ad = new Address();
        ad.setAddress(address);
        ad.setName(name);
        ad.setTele(tele);
        ad.setUser(user);
        return addressService.addAddress(ad);
    }
    @PostMapping ("/updateAddress")
    public int updateAddressByUser(@RequestParam Integer aid,@RequestParam String address ,@RequestParam String name,@RequestParam String tele,@RequestParam String uid)
    {
        User user = userService.getUserById(uid);
        Address ad = new Address();
        ad.setAid(aid);
        ad.setAddress(address);
        ad.setName(name);
        ad.setTele(tele);
        ad.setUser(user);
        return addressService.updateAddress(ad);
    }
    @PostMapping ("/deleteAddress")
    public int deleteAddressByUser(@RequestParam Integer aid)
    {
        return addressService.deleteAddress(aid);
    }
}
