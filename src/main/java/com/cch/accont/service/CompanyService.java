package com.cch.accont.service;

import com.cch.base.service.BaseService;
import com.cch.entity.Company;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
public interface CompanyService extends BaseService<Company,String> {
    /**
     * 根据公司名称获取公司信息
     * @param companyName
     * @return
     */
    Company getByCompanyName(String companyName) ;
    /**
     * 查询所有用户列表
     * @return
     */
    List<Company> listAll() ;

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
