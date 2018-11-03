package com.cch.entity;

import com.cch.base.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/3/14.
 * 库存基类
 */
@Entity
@Table(name = "t_repertory")
public class Repertory extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String goodsName;//物品名称
    private String goodsType;//物品类型

    private Long goodsNum;//物品数量

    private String supplier;//供货商

    private String state;//状态


    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
