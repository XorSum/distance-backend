package com.example.distance.weibo.Controllerr;

import com.example.distance.utils.result.Result;
import com.example.distance.weibo.service.FocusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/focus/")
public class FocusController {

    @Autowired
    FocusService focusService;

    @ApiOperation(value = "添加关注",notes = "user关注大V")
    @PostMapping(value = "/add/")
    public Result add(Integer userId, Integer vId) {
        // 关注了大V
        return focusService.add(userId, vId);
    }

    @ApiOperation(value = "取消关注",notes = "user取关大V")
    @DeleteMapping(value = "/del/")
    public Result del(Integer userId, Integer vId) {
        // 取关了大V
        return focusService.del(userId, vId);
    }

    @ApiOperation(value = "获取关注列表",notes = "查看user的关注情况")
    @GetMapping(value = "/Vlist/")
    public Result getFocueList(Integer userId) {
        // 获取关注列表，里面存这大V们的id
        return focusService.getFocueList(userId);
    }

//    @ApiOperation(value = "",notes = "")
//    @GetMapping(value = "/WBlist/")
//    public Result getWBList(String token) {
//        // 获取关注的大V发送的微博 ， 算法有待实现
//        return null;
//    }
//
//    @ApiOperation(value = "",notes = "")
//    @GetMapping(value = "/Recomdandlist/")
//    public Result getRecomdandList(String token) {
//        // 获取系统推荐的微博 ， 算法有待实现
//        return null;
//    }

}
