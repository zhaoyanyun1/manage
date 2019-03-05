package com.cch.accont.service;

import com.cch.base.service.BaseService;
import com.cch.entity.StockRemovalDetails;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
public interface StockRemovalDetailService extends BaseService<StockRemovalDetails,String> {
//    /**
//     * 查询所有出库记录
//     * @return
//     */
//    List<StockRemovalDetails> listAll() ;
    /**
     * 根据订单号查询所有出库记录
     * @return
     */
    List<StockRemovalDetails> listByOrderNum(String orderNum) ;



}
