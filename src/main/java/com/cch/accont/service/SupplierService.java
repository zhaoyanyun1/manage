package com.cch.accont.service;

import com.cch.base.service.BaseService;
import com.cch.entity.Repertory;
import com.cch.entity.Supplier;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
public interface SupplierService extends BaseService<Supplier,String> {
//    /**
//     * 根据用户名获取用户
//     * @param username
//     * @return
//     */
//    User getByuserName(String username) ;
//    /**
//     * 根据用户名和密码获取用户
//     * @param username
//     * @return
//     */
//    User getUser(String username, String passWd) ;
    /**
     * 查询所有供货商列表
     * @return
     */
    List<Supplier> listAll() ;

//    /**
//     * 获取用户的角色
//     * @param userId
//     * @return
//     */
//    List<Role> getRoleList(String userId);
//    /**
//     * 保存用户角色
//     */
//    void saveRoles(List<UserRoleKey> list);


}
