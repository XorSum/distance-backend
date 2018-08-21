package com.example.distance.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    static public String file(MultipartFile multipartFile){
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

    public static String string(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
