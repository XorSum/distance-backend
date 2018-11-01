package com.example.distance.weibo.Model;

import java.io.Serializable;


/**
 * Created by hantiaotiao on 2018/8/6.
 * Focus的复合主键类
 *
 * @Param userId
 * @Param VID
 * 由这两个个共同组成复合主键
 */
public class FocusMultiKey implements Serializable {

    private Integer userId;
    private Integer vId;

    //  ***重写hashCode与equals方法***

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((userId == null) ? 0 : userId.hashCode());
        result = PRIME * result + ((vId == null) ? 0 : vId.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final FocusMultiKey other = (FocusMultiKey) obj;
        if(userId == null){
            if(other.userId != null){
                return false;
            }
        }else if(!userId.equals(other.userId)){
            return false;
        }
        if(vId == null){
            if(other.vId != null){
                return false;
            }
        }else if(!vId.equals(other.vId)){
            return false;
        }
        return true;
    }

    public FocusMultiKey() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVId() {
        return vId;
    }

    public void setVId(Integer VId) {
        this.vId = VId;
    }
}
