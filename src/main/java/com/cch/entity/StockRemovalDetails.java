package com.cch.entity;

import com.cch.base.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/3/14.
 * 出库记录基类
 */
@Entity
@Table(name = "t_stockremovaldetails")
public class StockRemovalDetails extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goodsName;//物品名称
    private String goodsType;//物品类型
    private String specification;//物品规格
    private String price;//单价
    private Long goodsNum;//物品数量
    private Long money;//物品数量
    private String goodsAllocation;//货位


    private String orderNum;//订单号

    private String state;//状态
    private String remark;//备注

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getGoodsAllocation() {
        return goodsAllocation;
    }

    public void setGoodsAllocation(String goodsAllocation) {
        this.goodsAllocation = goodsAllocation;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
