package com.example.distance.weibo.Model;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;


    private Integer userId;  // 发出评论的人
    private String userName; // 发出评论的人的用户名
    private Integer ownerId; // 被评论的人
    private Integer weiboId; // 被评论的微博

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "Text")
    private String content; // 评论的内容
    private Date date;
    public Comment() {
        this.date = new Date();
    }

    public Comment(Integer userId,String userName,Integer ownerId,Integer weiboId,String content){
        this.userId = userId;
        this.userName = userName;
        this.ownerId = ownerId;
        this.weiboId = weiboId;
        this.content = content;
        this.date = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
