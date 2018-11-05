package com.cch.accont.service.impl;

import com.cch.accont.mapper.SupplierMapper;
import com.cch.accont.service.SupplierService;
import com.cch.base.service.impl.BaseServiceImpl;
import com.cch.entity.Supplier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier,String> implements SupplierService {

    @Resource
    private SupplierMapper superMapper;

    /*public User getByuserName(String username) {
        return userMapper.getByUserName(username);
    }

    public User getUser(String username, String passWd) {
        return userMapper.getUser(username,passWd);
    }*/

    public List<Supplier> listAll() {
        return superMapper.findAll(new Supplier());
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
