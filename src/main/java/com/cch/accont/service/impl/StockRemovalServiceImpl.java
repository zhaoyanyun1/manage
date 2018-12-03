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

//    public Repertory getBygoodsName(String goodsName,String supplier) {
//        return repertoryMapper.getBygoodsName(goodsName,supplier);
//    }
//    public Repertory getByid(Long id) {
//        return repertoryMapper.getByid(id);
//    }
//
//  /*  public User getUser(String username, String passWd) {
//        return userMapper.getUser(username,passWd);
//    }*/

    public List<StockRemoval> listAll() {
        return stockRemovalMapper.listAllByOrderDateDesc();
    }

    @Override
    public List<StockRemoval> listByOrderNum(String orderNum) {
        return stockRemovalMapper.listByOrderNum(orderNum);
    }

//    public List<Role> getRoleList(String  userId) {
//        return userMapper.getRoleList(userId);
//    }
//
//    @Override
//    @Transactional
//    public void saveRoles(List<UserRoleKey> list) {
//        for (UserRoleKey u:list) {
//            userMapper.saveRoles(u.getUserId(),u.getRoleId());
//        }
//    }


}
