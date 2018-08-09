package com.example.distance.weibo.Controllerr;

import com.example.distance.utils.result.Result;
import com.example.distance.utils.result.SuccessResult;
import com.example.distance.weibo.Model.Weibo;
import com.example.distance.weibo.service.WeiboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@RestController
@RequestMapping(value = "/weibo/")
@Api("微博相关的api " +
        "创建微博使用方法" +
        "1. post create 创建一条空微博" +
        "2. post content 填写文字内容" +
        "3. /file/upload/ 上传图片并获取图片地址"+
        "3. post picture 添加图片地址 delete picture删除图片地址 "+
        " 查看微博使用方法 "+
        "1. get weibo 获取文字内容"+
        "2. get pictures 获取图片地址"+
        "3. file/download 下载图片"
)
public class WeiboController {


    @Autowired
    WeiboService weiboService;

    @ApiOperation(value = "获取微博", notes = " 获取一个微博除了图片以外的所有内容 ", response = Weibo.class)
    @GetMapping(value = "/weibo/")
    public Result getWeibo(Integer weiboId) {
        return weiboService.getWeibo(weiboId);
    }


    @ApiOperation(value = "创建空微博", notes = " 创建一个空的微博，之后使用调用另外几个接口进行添加图片和内容 ", response = Weibo.class)
    @PostMapping(value = "/create/")
    public Result create(Integer userId) {
        return weiboService.createWeibo(userId);
    }

    @ApiOperation(value = "填写文字内容", notes = " 给一条微博设置文字内容 ", response = Weibo.class)
    @PostMapping(value = "/content/")
    public Result setContent(Integer userId, Integer weiboId, String content) {
        return weiboService.setContent(userId, weiboId, content);
    }

    @ApiOperation(value = "添加图片", notes = " 增添一个图片的路径 ", response = Result.class)
    @PostMapping(value = "/picture/")
    public Result addContent(Integer userId, Integer weiboId, String picPath) {
        // 添加图片
        return weiboService.addPic(userId, weiboId, picPath);
    }

    @ApiOperation(value = "删除图片", notes = " 删除一个图片的路径 ", response = Result.class)
    @DeleteMapping(value = "/picture/")
    public Result delContent(Integer userId, Integer weiboId, String picPath) {
        // 删除图片
        return weiboService.delPic(userId, weiboId, picPath);
    }

    @ApiOperation(value = "获取图片", notes = " 获取一个微博的所有图片的路径 ", response = Array.class)
    @GetMapping(value = "/pictures/")
    public Result getPictures(Integer weiboId) {
        // 这个只返回一个图片名称的列表， 前端还需要去 /file/download/接口下载图片
        return weiboService.getPictures(weiboId);
    }


}
