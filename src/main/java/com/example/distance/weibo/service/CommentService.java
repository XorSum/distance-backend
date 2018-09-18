package com.example.distance.weibo.service;

import com.example.distance.sign.model.User;
import com.example.distance.sign.repository.UserRepository;
import com.example.distance.utils.result.Result;
import com.example.distance.weibo.Model.Comment;
import com.example.distance.weibo.Model.Weibo;
import com.example.distance.weibo.repository.CommentRepository;
import com.example.distance.weibo.repository.WeiboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    UserRepository userRepository;

    public Result addComment(Integer userId,Integer weiboId,String content){
        try {
            if (content==null||content.equals("")){
                return Result.error("内容为空");
            }
            Weibo weibo = weiboRepository.findOneByWeiboId(weiboId);
            if (weibo==null){
                return Result.error("没有这个微博");
            }else {
                User user = userRepository.findOneById(userId);
                Comment comment = new Comment(userId,user.getUserName(), weibo.getUserId(), weiboId, content);
                commentRepository.save(comment);
                return Result.success(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    public Result getAllComments(Integer weiboId){
        try{
            Iterable<Comment> comments = commentRepository.findAllByWeiboIdOrderByDate(weiboId);
            if (comments==null) {
                return Result.error("没有这个微博");
            }else {
                return Result.success(comments);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    public Result getOneComments(Integer commentId){
        try{
            Comment comment = commentRepository.findOneByCommentId(commentId);
            if (comment==null) {
                return Result.error("没有这个评论");
            }else {
                return Result.success(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }

    public Result delComment(Integer commentId){
        try {
           Comment comment = commentRepository.findOneByCommentId(commentId);
            if (comment==null){
                return Result.error("没有这个评论");
            }else {
                commentRepository.delete(comment);
                return Result.success(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error();
        }
    }


}
