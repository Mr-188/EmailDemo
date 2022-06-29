package com.example.emaildemo.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
@Component
@Service
public class Rand {

    //生成随机6位数
    public int R(){
        int i;
        Random random = new Random();
        i = random.nextInt(900000) + 100000;
        return i;
    }
}
