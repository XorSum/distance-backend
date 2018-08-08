package com.example.distance.weibo.Controllerr;

import com.example.distance.utils.result.Result;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/focus/")
public class FocusController {

    @PostMapping(value = "/add/")
    public Result add(String token, String VId){
        // 关注了大V
        return null;
    }

    @DeleteMapping(value = "/del/")
    public Result del(String token, String VId){
        // 取关了大V
        return null;
    }

    @GetMapping(value = "/Vlist/")
    public Result getFocueList(String token){
        // 获取关注列表，里面存这大V们的id
        return null;
    }

    @GetMapping(value = "/WBlist/")
    public Result getWBList(String token){
        // 获取关注的大V发送的微博 ， 算法有待实现
        return null;
    }

    @GetMapping(value = "/Recomdandlist/")
    public Result getRecomdandList(String token){
        // 获取系统推荐的微博 ， 算法有待实现
        return null;
    }

}
