package com.example.distance.weibo.Controllerr;

import com.example.distance.utils.JwtUtils;
import com.example.distance.utils.result.Result;
import com.example.distance.weibo.service.FocusService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/focus/")
public class FocusController {

    @Autowired
    FocusService focusService;

    @ApiOperation(value = "添加关注",notes = "user关注大V")
    @PostMapping(value = "/add/")
    public Result add(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                      @ApiParam(value = "大V的id" ,required=true ) @RequestParam Integer vId) {
        // 关注了大V
        Integer userId = JwtUtils.getUserId(jwt);
        if (userId != null) {
            return focusService.add(userId, vId);
        }else {
            return Result.error();
        }
    }

    @ApiOperation(value = "取消关注",notes = "user取关大V")
    @DeleteMapping(value = "/del/")
    public Result del(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                      @ApiParam(value = "大V的id" ,required=true ) @RequestParam Integer vId) {
        // 取关了大V
        Integer userId = JwtUtils.getUserId(jwt);
        if (userId != null) {
            return focusService.del(userId, vId);
        }else {
            return Result.error();
        }
    }

    @ApiOperation(value = "获取关注列表",notes = "查看user的关注情况")
    @GetMapping(value = "/Vlist/")
    public Result getFocueList(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                               @ApiParam(value = "用户的id" ,required=true ) @RequestParam Integer userId) {
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
