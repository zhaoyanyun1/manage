package com.cch.entity;



import com.cch.base.entity.BaseEntity;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/3/14.
 * 供货商基类
 */
@Entity
@Table(name = "t_supplier")
public class Supplier extends BaseEntity {


    @Id
    private String supplierName;

    private String supplierTel;

    private String state;


    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String Sal(){
        return new Md5Hash(this.getSupplierName() + this.getSupplierTel() + this.getState()).toString();
    }
}
