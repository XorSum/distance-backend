package com.example.distance.weibo.service;

import com.example.distance.utils.result.ErrorResult;
import com.example.distance.utils.result.Result;
import com.example.distance.utils.result.SuccessResult;
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

    public Result addComment(Integer userId,Integer weiboId,String content){
        try {
            if (content==null||content.equals("")){
                return new ErrorResult("内容为空");
            }
            Weibo weibo = weiboRepository.findOneByWeiboId(weiboId);
            if (weibo==null){
                return new ErrorResult("没有这个微博");
            }else {
                Comment comment = new Comment(userId, weibo.getUserId(), weiboId, content);
                commentRepository.save(comment);
                return new SuccessResult(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult();
        }
    }

    public Result getAllComments(Integer weiboId){
        try{
            Iterable<Comment> comments = commentRepository.findAllByWeiboIdOrderByDate(weiboId);
            if (comments==null) {
                return new ErrorResult("没有这个微博");
            }else {
                return new SuccessResult(comments);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult();
        }
    }

    public Result getOneComments(Integer commentId){
        try{
            Comment comment = commentRepository.findOneByCommentId(commentId);
            if (comment==null) {
                return new ErrorResult("没有这个评论");
            }else {
                return new SuccessResult(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult();
        }
    }

    public Result delComment(Integer commentId){
        try {
           Comment comment = commentRepository.findOneByCommentId(commentId);
            if (comment==null){
                return new ErrorResult("没有这个评论");
            }else {
                commentRepository.delete(comment);
                return new SuccessResult(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult();
        }
    }


}