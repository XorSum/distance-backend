package com.example.distance.utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendSmsTest {

    @Autowired
    SendSms sendSms;

//    @Test
//    void send() {
//
//        try{
//            SendSms.send("15966026305","123456");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }



}