package com.example.distance.login.service;


import com.example.distance.login.model.ProveNumber;
import com.example.distance.login.model.UserPassword;
import com.example.distance.login.repository.ProveNumberRepository;
import com.example.distance.login.repository.UserPasswordRepository;
import com.example.distance.utils.JwtUtils;
import com.example.distance.utils.MD5;
import com.example.distance.utils.SendSms;
import com.example.distance.utils.result.Result;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignService {

    @Autowired
    ProveNumberRepository proveNumberRepository;

    @Autowired
    UserPasswordRepository userPasswordRepository;


    public Result signin(String phonenumber,String firstpassword){
        try{
            UserPassword userPassword= userPasswordRepository.findByPhonenumber(phonenumber);
            if (userPassword!=null) {
                String password = MD5.string(firstpassword + userPassword.getSalt());
                if (password.equals(userPassword.getPassword())) {
                    String token = JwtUtils.createToken(userPassword.getId());
                    return Result.success(token);
                } else {
                    return Result.error("用户名或密码错误");
                }
            }else {
                return Result.error("用户不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("登陆失败");
        }
    }

    public Result sendSMS(String phonenumber){
        System.out.println(phonenumber);
        try {
            if (userPasswordRepository.findByPhonenumber(phonenumber) == null){
                String randomnum= RandomStringUtils.randomNumeric(6);
                if (SendSms.send(phonenumber,randomnum)==true){
                    ProveNumber proveNumber = new ProveNumber(phonenumber,randomnum);
                    proveNumberRepository.save(proveNumber);
                    return Result.success("发送成功");
                }else {
                    return Result.error("短信发送失败");
                }
            }
            else {
                return Result.error("该用户已经注册");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error("短信发送失败");
        }
    }


    public Result proveAndSignin(String phonenumber, String provenum,  String password){
        try {
            if (proveNumberRepository.findByPhonenumberAndProvenum(phonenumber, provenum) != null) {
                String salt= RandomStringUtils.randomAlphanumeric(10);
                UserPassword userPassword=new UserPassword(phonenumber,salt,MD5.string(password+salt));
                userPasswordRepository.save(userPassword);
                return Result.success("用户注册成功");
            } else{
                return Result.error("验证码错误");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.error("用户注册失败");
        }

    }
    



}


