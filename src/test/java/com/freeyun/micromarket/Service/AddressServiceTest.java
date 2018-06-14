package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Address;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.UserRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {
    @Autowired private  AddressService addressService;
    @Autowired private UserService userService;

    @Test
    public void addAddress() {
        Address address = new Address();
        User user = userService.getUserById("ovjQr5EE9KlbYlHXW6p7gJZqdoKM");
        address.setAddress("北京市五道口职业技术学院");
        address.setName("王王");
        address.setUser(user);
        addressService.addAddress(address);
    }

    @Test
    public void findAddressByUser() {
        User user = userService.getUserById("ovjQr5EE9KlbYlHXW6p7gJZqdoKM");
        List<Address> addresses = addressService.findAddressByUser(user);
        assertThat(addresses.size(),equalTo(2));


    }

}