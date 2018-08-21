package com.cch.entity;



import com.cch.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/3/14.
 * 用户基类
 */
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {


    @Id
    private String userName;

    private String passWd ;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }


//    public String Sal(){
//        return new Md5Hash(this.getPassWd() + this.getUserName()).toString();
//    }
}
