package com.cch.accont.mapper;

import com.cch.base.dao.BaseMapper;
import com.cch.entity.StockRemovalDetails;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Mapper
public interface StockRemovalDetailMapper extends BaseMapper<StockRemovalDetails,String> {

        /**
     * 根据订单号查询所有出库记录
     * @param orderNum
     * @return
     */
    @Select("SELECT * FROM manage.t_stockremovaldetails where order_num=#{orderNum} ")
    @Results({
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "goodsAllocation", column = "goods_allocation"),
            @Result(property = "goodsName", column = "goods_name"),
            @Result(property = "goodsType", column = "goods_type"),
            @Result(property = "goodsNum", column = "goods_num"),
    })
    List<StockRemovalDetails> listByOrderNum(@Param("orderNum") String orderNum);



    /**
     * 查询所有出库记录根据出库日期排序
     * @param
     * @return
     */
    @Select("SELECT * FROM manage.t_stockremovaldetails order by date desc")
    @Results({
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "goodsAllocation", column = "goods_allocation"),
            @Result(property = "despatchMode", column = "despatch_mode"),
            @Result(property = "clientAddress", column = "client_address"),
    })
    List<StockRemovalDetailMapper> listAllByOrderDateDesc();


}
