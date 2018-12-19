package com.cch.entity;



import com.cch.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/3/14.
 * 公司信息基类
 */
@Entity
@Table(name = "t_company")
public class Company extends BaseEntity {


    @Id
    private String companyName;//公司名称

    private String companyTel ;//公司电话

    private String companyAddress ;//公司电话

    private String state ;//状态

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    //    public String Sal(){
//        return new Md5Hash(this.getPassWd() + this.getUserName()).toString();
//    }
}
