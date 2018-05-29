package com.freeyun.micromarket.Controller.UserController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freeyun.micromarket.Domain.User;
import com.freeyun.micromarket.Domain.WeixinRespense;
import com.freeyun.micromarket.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class UserController {
    @Autowired UserService userService;
    @Autowired ObjectMapper objectMapper;
    private  String wxspAppid = "wxf2dec368575b229d";
    //小程序的 app secret (在微信小程序管理后台获取)
    private  String wxspSecret = "d2c768841b5c95f177901a4464ae8b9f";
    private String openid;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @PostMapping ("/signinUser")
    public User signinUser(@RequestParam String code) throws IOException
    {
        RestTemplate restTemplate = new RestTemplate();
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" +code;
        String url = "https://api.weixin.qq.com/sns/jscode2session?"+params;
        String response = restTemplate.getForObject(url,String.class);
        logger.info("response:"+response);
        WeixinRespense weixinRespense = objectMapper.readValue(response,WeixinRespense.class);
        String session_key = weixinRespense.getSession_key();//h+BXgRf9lWEa6G/xKrZLDA==
        openid= weixinRespense.getOpenid();//ovjQr5EE9KlbYlHXW6p7gJZqdoKM
        logger.info("session_key:"+session_key);
        logger.info("openid:"+openid);
        User user = new User();
        user.setUid(openid);
        user.setBalence(Float.valueOf(0));
        if (userService.existbyid(openid))
        {
            return userService.getUserById(openid);
        }
        else {
            if (userService.signupUser(user) == 1)
            {
                return userService.getUserById(openid);
            }
            else {
                return null;
            }
        }
//        String session_key = "h+BXgRf9lWEa6G/xKrZLDA==";
//        try {
//            String result = AesCbcUtil.decrypt(encryptedData,session_key,iv,"UTF-8");
//            logger.info("result:"+result);
//        }
//        catch (Exception e)
//        {
//            logger.error(e.getLocalizedMessage());
//        }
    }
    @GetMapping("getUser")
    public User getUser()
    {
        if (userService.existbyid(openid))
        {
            return userService.getUserById(openid);
        }
        else {
            return null;
        }
    }
}
