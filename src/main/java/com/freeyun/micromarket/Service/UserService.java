package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    @Autowired private UserRespository userRespository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    public User getUserById(String uid)
    {
        User user = null;
        try {
            user = userRespository.findById(uid).get();
        }
        catch (Exception e)
        {
            logger.error(e.getLocalizedMessage());
        }
        return user;


    }
    public int signupUser(User user)
    {
        try {
            userRespository.save(user);
            return 1;// or 0
        }catch (Exception e)
        {
            return 0;// error
        }
    }
    public Boolean existbyid(String uid) {
        User user = null;
        try{
             user= userRespository.findById(uid).get();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
