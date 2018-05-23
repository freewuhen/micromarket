package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    @Autowired private UserRespository userRespository;
    public int signinUser(User user)
    {
        return 1;// or 0
    }
    public int signupUser(User user)
    {
        return 1;// or 0
    }
}
