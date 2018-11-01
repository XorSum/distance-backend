package com.example.distance.weibo.Model;

import java.io.Serializable;

public class WeibiPictureMultikey  implements Serializable {

    private String picPath;

    private Integer weiboId;
    
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((picPath == null) ? 0 : picPath.hashCode());
        result = PRIME * result + ((weiboId == null) ? 0 : weiboId.hashCode());
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

        final WeibiPictureMultikey other = (WeibiPictureMultikey) obj;
        if(picPath == null){
            if(other.picPath != null){
                return false;
            }
        }else if(!picPath.equals(other.picPath)){
            return false;
        }
        if(weiboId == null){
            if(other.weiboId != null){
                return false;
            }
        }else if(!weiboId.equals(other.weiboId)){
            return false;
        }
        return true;
    }

    public WeibiPictureMultikey() {
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
}
