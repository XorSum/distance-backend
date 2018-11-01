package com.example.distance.weibo.Controllerr;

import com.example.distance.aop.annotation.LogAnnotation;
import com.example.distance.utils.JwtUtils;
import com.example.distance.utils.result.Result;
import com.example.distance.weibo.service.CommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/comment/")
@LogAnnotation
public class CommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation(value = "获取评论",notes = "获取一条微博下所有的评论的数组")
    @GetMapping(value = "/getall/")
    public Result getComments(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                              @ApiParam(value = "weiboId" ,required=true ) @RequestParam Integer weiboId){
        try{
            return commentService.getAllComments(weiboId);
        }catch (Exception e){
            return Result.error();
        }
    }


    @ApiOperation(value = "添加评论",notes = "给一条微博添加一个评论")
    @PostMapping(value = "/add/")
    public Result addComment(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                              @ApiParam(value = "weiboId" ,required=true ) @RequestParam Integer weiboId,
                             @ApiParam(value = "content" ,required=true ) @RequestParam String content ){
        try{
            Integer userId = JwtUtils.getUserId(jwt);
            return commentService.addComment(userId,weiboId,content);
        }catch (Exception e){
            return Result.error();
        }
    }

    @ApiOperation(value = "删除评论",notes = "删除一个评论")
    @DeleteMapping(value = "/del/")
    public Result delComment(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                             @ApiParam(value = "commentId" ,required=true ) @RequestParam Integer commentId){
        try{
            return commentService.delComment(commentId);
        }catch (Exception e){
            return Result.error();
        }
    }


}
