package com.example.distance.weibo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weibo")
public class Weibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weiboId;

    private int userId;
    private String userName;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "Text")
    private String content; // 文字内容

    private Date date;  // 发送的时间

    public Weibo() {
        this.date = new Date();
    }

    public Weibo(int userId) {
        this.userId = userId;
        this.date = new Date();
    }

    public int getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(int weiboId) {
        this.weiboId = weiboId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
