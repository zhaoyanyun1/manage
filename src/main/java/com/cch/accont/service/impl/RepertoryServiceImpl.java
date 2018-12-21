package com.cch.accont.service.impl;

import com.cch.accont.mapper.RepertoryMapper;
import com.cch.accont.service.RepertoryService;
import com.cch.base.service.impl.BaseServiceImpl;
import com.cch.entity.Repertory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Service
public class RepertoryServiceImpl extends BaseServiceImpl<Repertory,String> implements RepertoryService {

    @Resource
    private RepertoryMapper repertoryMapper;

    public Repertory getBygoodsName(String goodsName,String supplier) {
        return repertoryMapper.getBygoodsName(goodsName,supplier);
    }

    public Repertory getByNTSS(String goodsName, String goodsType, String supplier, String specification) {
        return repertoryMapper.getNTSS(goodsName,goodsType,supplier,specification);
    }

    public Repertory getByid(Long id) {
        return repertoryMapper.getByid(id);
    }

  /*  public User getUser(String username, String passWd) {
        return userMapper.getUser(username,passWd);
    }*/

    public List<Repertory> listAll() {
        return repertoryMapper.findAll(new Repertory());
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
