package com.cch.entity;

import com.cch.base.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/14.
 * 出库记录基类
 */
@Entity
@Table(name = "t_stockremoval")
public class StockRemoval extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String goodsName;//物品名称
    private String goodsType;//物品类型
    private String goodsAllocation;//货位
    private String price;//单价
    private Long goodsNum;//物品数量

    private String orderNum;//订单号
    private String salesman;//业务员
    private String despatchMode;//发货方式
    private String money;//结算金额
    private String clientAddress;//客户地址
    private String client;//客户
    private String date;//出库时间
    private String state;//状态
    private String remark;//备注


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsAllocation() {
        return goodsAllocation;
    }

    public void setGoodsAllocation(String goodsAllocation) {
        this.goodsAllocation = goodsAllocation;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getDespatchMode() {
        return despatchMode;
    }

    public void setDespatchMode(String despatchMode) {
        this.despatchMode = despatchMode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
}
