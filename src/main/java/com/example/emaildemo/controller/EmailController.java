package com.example.emaildemo.controller;

import com.example.emaildemo.util.MailService;
import com.example.emaildemo.util.Rand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class EmailController {

    @Autowired
    private MailService mailService;
    @Autowired
    private Rand rand;

    @RequestMapping("/email")
    @ResponseBody
    public int Email(@RequestBody Map<String, Object> map) {
        String email = (String) map.get("email");
        int i = rand.R();       //随机6位数
        String s = "你的验证码为 " + i + " "; //邮件内容

        mailService.sendSimpleMail(
                email, //接收者
                "EmailDemo 验证码",        //邮件主题
                s);                 //邮件内容

        return i; //将随机数返回到前端
    }

}
