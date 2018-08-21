package com.cch.accont.service;

import com.cch.base.service.BaseService;
import com.cch.entity.User;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
public interface UserService extends BaseService<User,String> {
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getByuserName(String username) ;

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
