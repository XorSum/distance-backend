package com.example.distance.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    static public String getMD5(MultipartFile multipartFile){
        try {
            FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            byte[] buffer = new byte[1024];

            int length = -1;

            while ((length = fileInputStream.read(buffer, 0, 1024)) != -1) {

                messageDigest.update(buffer, 0, length);
            }

            BigInteger bigInt = new BigInteger(1, messageDigest.digest());

            System.out.println("文件md5值：" + bigInt.toString(16));

            return bigInt.toString(16);

        } catch (IOException e) {

            e.printStackTrace();

            return null;

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

            return null;
        }


    }

}
