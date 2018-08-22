package com.example.distance.login.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPassword {

    @Id
    @GeneratedValue
    private Integer id;                   //id
    private String phonenumber;       //手机号
    private String salt;              //盐
    private String password;          //密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPassword() {
    }

    public UserPassword(String phonenumber, String salt, String password) {
        this.phonenumber = phonenumber;
        this.salt = salt;
        this.password = password;
    }
}
