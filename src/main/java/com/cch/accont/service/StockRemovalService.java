package com.cch.accont.service;

import com.cch.base.service.BaseService;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
public interface StockRemovalService extends BaseService<StockRemoval,String> {
    /**
     * 查询所有出库记录
     * @return
     */
    List<StockRemoval> listAll() ;
    /**
     * 根据订单号查询所有出库记录
     * @return
     */
    StockRemoval stockremovalByOrderNum(String orderNum) ;



}
