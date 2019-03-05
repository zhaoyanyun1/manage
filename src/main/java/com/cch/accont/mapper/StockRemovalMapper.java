package com.cch.accont.mapper;

import com.cch.base.dao.BaseMapper;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Mapper
public interface StockRemovalMapper extends BaseMapper<StockRemoval,String> {

        /**
     * 根据订单号查询所有出库记录
     * @param orderNum
     * @return
     */
    @Select("SELECT * FROM manage.t_stockremoval where order_num=#{orderNum} ")
    @Results({
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "despatchMode", column = "despatch_mode"),
            @Result(property = "clientAddress", column = "client_address"),
    })
    StockRemoval stockremovalByOrderNum(@Param("orderNum") String orderNum);



    /**
     * 查询所有出库记录根据出库日期排序
     * @param
     * @return
     */
    @Select("SELECT * FROM manage.t_stockremoval order by date desc")
    @Results({
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "despatchMode", column = "despatch_mode"),
            @Result(property = "clientAddress", column = "client_address"),
    })
    List<StockRemoval> listAllByOrderDateDesc();


}
