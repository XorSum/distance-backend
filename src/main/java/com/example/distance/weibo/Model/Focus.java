package com.example.distance.weibo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Time;
import java.util.Date;

@Entity
@IdClass(FocusMultiKey.class)
public class Focus {

    @Id
    private Integer userId;

    @Id
    private Integer VId;

    private Date focusDate ;

    public Focus() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVId() {
        return VId;
    }

    public void setVId(Integer VId) {
        this.VId = VId;
    }

    public Date getFocusDate() {
        return focusDate;
    }

    public void setFocusDate(Date focusDate) {
        this.focusDate = focusDate;
    }
}
