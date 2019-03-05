package com.cch.accont.service.impl;

import com.cch.accont.mapper.RepertoryMapper;
import com.cch.accont.mapper.StockRemovalMapper;
import com.cch.accont.service.RepertoryService;
import com.cch.accont.service.StockRemovalService;
import com.cch.base.service.impl.BaseServiceImpl;
import com.cch.entity.Repertory;
import com.cch.entity.StockRemoval;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Service
public class StockRemovalServiceImpl extends BaseServiceImpl<StockRemoval,String> implements StockRemovalService {

    @Resource
    private StockRemovalMapper stockRemovalMapper;


    public List<StockRemoval> listAll() {
        return stockRemovalMapper.listAllByOrderDateDesc();
    }

    public StockRemoval stockremovalByOrderNum(String orderNum) {
        return stockRemovalMapper.stockremovalByOrderNum(orderNum);
    }



}
