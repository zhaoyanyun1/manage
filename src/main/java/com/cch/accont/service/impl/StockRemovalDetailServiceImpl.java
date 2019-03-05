package com.cch.accont.service.impl;

import com.cch.accont.mapper.StockRemovalDetailMapper;
import com.cch.accont.service.StockRemovalDetailService;
import com.cch.base.service.impl.BaseServiceImpl;
import com.cch.entity.StockRemovalDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Service
public class StockRemovalDetailServiceImpl extends BaseServiceImpl<StockRemovalDetails,String> implements StockRemovalDetailService {

    @Resource
    private StockRemovalDetailMapper stockRemovalDetailMapper;
//
//    public List<StockRemovalDetails> listAll() {
//        return stockRemovalDetailMapper.findAll();
//    }

    public List<StockRemovalDetails> listByOrderNum(String orderNum) {
        return stockRemovalDetailMapper.listByOrderNum(orderNum);
    }


}
