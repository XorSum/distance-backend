package com.example.distance.sign.model;

import javax.persistence.*;

@Entity
@Table(name = "prove_number")
public class ProveNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer proveid;      //主键
    private String phonenumber;   //手机号
    private String provenum;     //验证码

    public Integer getProveid() {
        return proveid;
    }

    public void setProveid(Integer proveid) {
        this.proveid = proveid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getProvenum() {
        return provenum;
    }

    public void setProvenum(String provenum) {
        this.provenum = provenum;
    }

    public ProveNumber() {
    }

    public ProveNumber(String phonenumber, String randomnum) {
        this.phonenumber = phonenumber;
        this.provenum = randomnum;
    }
}



