package com.example.distance.weibo.service;

import com.example.distance.utils.result.Result;
import com.example.distance.weibo.Model.Weibo;
import com.example.distance.weibo.Model.WeiboPicture;
import com.example.distance.weibo.repository.WeiboPictureRepository;
import com.example.distance.weibo.repository.WeiboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Service
public class WeiboService {

    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    WeiboPictureRepository wpRspository;

    public Result createWeibo(Integer userId) {
        Weibo weibo = new Weibo(userId);
        weibo.setUserName(" userName ");
        weiboRepository.save(weibo);
        return Result.success(weibo);
    }


    public Result setContent(Integer userId, Integer weiboId, String content) {
        Weibo weibo = weiboRepository.findOneByWeiboId(weiboId);
        if (weibo == null)
            return Result.error();
        weibo.setContent(content);
        weiboRepository.save(weibo);
        return Result.success(weibo);
    }

    public Result addPic(Integer userId, Integer weiboId, String picPath) {

        WeiboPicture weiboPicture = new WeiboPicture();
        weiboPicture.setPicPath(picPath);
        weiboPicture.setWeiboId(weiboId);
        weiboPicture.setUserId(userId);
        wpRspository.save(weiboPicture);

        return Result.success();
    }

    public Result delPic(Integer userId, Integer weiboId, String picPath) {

        WeiboPicture weiboPicture = wpRspository.findByWeiboIdAndPicPath(weiboId,picPath);
        if (weiboPicture==null)
            return Result.error();
        wpRspository.delete(weiboPicture);
        return Result.success();

    }

    public Result getWeibo(Integer weiboId) {
        Weibo weibo = weiboRepository.findOneByWeiboId(weiboId);
        if (weibo == null)
            return Result.error();
        return Result.success(weibo);
    }

    public Result getAllWeibo() {
        List<Weibo> weibos = weiboRepository.findAll();
        if (weibos == null)
            return Result.error();
        return Result.success(weibos);
    }

    public Result getPictures(Integer weiboId) {
        Iterable<WeiboPicture> ret = wpRspository.findAllByWeiboId(weiboId);
        return Result.success(ret);
    }

    public Result searchByContent(String keyword){
        List weibos = weiboRepository.findAllByContent(keyword);
        if (weibos==null){
            return Result.error("根据相关法律法规，部分搜索结果不予展示");
        }else {
            return Result.success(weibos);
        }
    }

    public Result searchByUserName(String keyword){
        List weibos = weiboRepository.findAllByUserName(keyword);
        if (weibos==null){
            return Result.error("根据相关法律法规，部分搜索结果不予展示");
        }else {
            return Result.success(weibos);
        }
    }


}
