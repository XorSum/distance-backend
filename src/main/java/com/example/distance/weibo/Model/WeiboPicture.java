package com.example.distance.weibo.Model;

import javax.persistence.*;

@Entity
@IdClass(WeibiPictureMultikey.class)
@Table(name = "weibo_picture")
public class WeiboPicture {

    @Id
    private String picPath;

    @Id
    private Integer weiboId;

    private Integer userId;

    public WeiboPicture() {
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
