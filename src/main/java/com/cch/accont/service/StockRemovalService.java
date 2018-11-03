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
//    /**
//     * 根据物品名称获取物品
//     * @param goodsName
//     * @return
//     */
//    Repertory getBygoodsName(String goodsName, String supplier) ;
//    /**
//     * 根据id获取物品
//     * @param id
//     * @return
//     */
//    Repertory getByid(Long id) ;
//    /**
//     * 根据用户名和密码获取用户
//     * @param username
//     * @return
//     */
//    User getUser(String username, String passWd) ;
    /**
     * 查询所有出库记录
     * @return
     */
    List<StockRemoval> listAll() ;

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
