package com.example.distance.weibo.Controllerr;

import com.example.distance.utils.result.Result;
import com.example.distance.utils.result.SuccessResult;
import com.example.distance.weibo.Model.Weibo;
import com.example.distance.weibo.service.WeiboService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@RestController
@RequestMapping(value = "/weibo/")
public class WeiboController {

    @Autowired
    WeiboService weiboService;

    @ApiOperation(value = "获取微博", notes = " 获取一个微博除了图片以外的所有内容 ", response = Weibo.class)
    @GetMapping(value = "/Weibo/")
    public Result getWeibo(int weiboId){
        return weiboService.getWeibo(weiboId);
    }


    @ApiOperation(value = "创建空微博", notes = " 创建一个空的微博，之后使用调用另外几个接口进行添加图片和内容 ", response = Weibo.class)
    @PostMapping(value = "/create/")
    public Result create( String userId){
        return weiboService.createWeibo(Integer.valueOf(userId));
    }

    @ApiOperation(value = "填写文字内容", notes = " 给一条微博设置文字内容 ", response = Weibo.class)
    @PostMapping(value = "/Content/")
    public Result setContent(Integer userId,Integer weiboId,String content){
        return weiboService.setContent(userId,weiboId,content);
    }

    @ApiOperation(value = "添加图片", notes = " 增添一个图片的路径 ", response = Result.class)
    @PostMapping(value = "/Picture/")
    public Result addContent(Integer userId,Integer weiboId,String picPath){
        // 添加图片
        return weiboService.addPic(userId,weiboId,picPath);
    }
    @ApiOperation(value = "删除图片", notes = " 删除一个图片的路径 ", response = Result.class)
    @DeleteMapping(value = "/Picture/")
    public Result delContent(Integer userId,int weiboId,String picPath){
        // 删除图片
        return weiboService.delPic(userId,weiboId,picPath);
    }

    @ApiOperation(value = "获取图片", notes = " 获取一个微博的所有图片的路径 ", response = Array.class)
    @GetMapping(value = "/Pictures/")
    public Result getPictures(int weiboId){
        // 这个只返回一个图片名称的列表， 前端还需要去 /file/download/接口下载图片
        return weiboService.getPictures(weiboId);
    }


}
