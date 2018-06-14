package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Address;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.AddressRespository;
import com.freeyun.micromarket.Respository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired  private AddressRespository addressRespository;
    @Autowired  private UserRespository userRespository;
    private Logger logger  = LoggerFactory.getLogger(AddressService.class);
    private Boolean existAdsressByid(Integer aid)
    {
        Address address = null;
        try {
            address = addressRespository.findById(aid).get();
            return true;
        }catch (Exception e)
        {
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }
    public int addAddress(Address address)
    {
        addressRespository.save(address);
        return 1;
    }
    public int deleteAddress(Integer aid)
    {
        if (existAdsressByid(aid) == false)
        {
            return -1;
        }
        else {
            try {
                addressRespository.deleteById(aid);
                return 1;
            }catch (Exception e)
            {
                logger.error(e.getLocalizedMessage());
                return 0;
            }


        }

    }
    public int updateAddress(Address address)
    {
        if (existAdsressByid(address.getAid()) == false)
        {
            return -1;
        }
        else {
            try {
                addressRespository.save(address);
                return 1;
            }catch (Exception e)
            {
                logger.error(e.getLocalizedMessage());
                return 0;
            }


        }

    }
    public List<Address> findAddressByUser(User user)
    {
        return addressRespository.findDistinctByUser(user);
    }
}
