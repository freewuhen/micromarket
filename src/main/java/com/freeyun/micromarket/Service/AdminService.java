package com.freeyun.micromarket.Service;

import com.freeyun.micromarket.Domain.Admin;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AdminService {
    @GetMapping("/signinAdmin")
    public int signinAdmin(Admin admin)
    {
        return 1;// or 0
    }
    @PostMapping("/signupAdmin")
    public int signupAdmin(Admin admin)
    {
        return 1;// or 0
    }
}
