package com.example.distance.login.controller;


import com.example.distance.login.service.SignService;
import com.example.distance.utils.result.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign/")
public class SignController {


    @Autowired
    SignService signService;


    @ApiOperation(value = "登录", notes = "  ", response = Result.class)
    @PostMapping(value = "/in/")
    public Result signin(@ApiParam(value = "手机号" ,required=true ) @RequestParam String phonenumber,
                         @ApiParam(value = "密码（建议取MD5值） " ,required=true ) @RequestParam String password){
        return signService.signin(phonenumber,password);
    }


    @ApiOperation(value = "向手机发送验证码", notes = "  ", response = Result.class)
    @PostMapping(value = "/sendSMS/")
    public Result setSMS(@ApiParam(value = "手机号" ,required=true ) @RequestParam String phonenumber) {
        return signService.sendSMS(phonenumber);
    }


    @ApiOperation(value = "验证注册", notes = "  ", response = Result.class)
    @PostMapping(value = "/up/")
    public Result signup(@ApiParam(value = "手机号" ,required=true )  @RequestParam String phonenumber,
                         @ApiParam(value = "验证码" ,required=true )  @RequestParam String provenum,
                         @ApiParam(value = "密码（建议取MD5值） " ,required=true ) @RequestParam String password) {
        return signService.proveAndSignin(phonenumber,provenum,password);
    }

}
