package com.cch.accont.service.impl;

import com.cch.accont.mapper.CompanyMapper;
import com.cch.accont.mapper.UserMapper;
import com.cch.accont.service.CompanyService;
import com.cch.accont.service.UserService;
import com.cch.base.service.impl.BaseServiceImpl;
import com.cch.entity.Company;
import com.cch.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company,String> implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    public Company getByCompanyName(String companyName) {
        return companyMapper.getByCompanyName(companyName);
    }


    public List<Company> listAll() {
        return companyMapper.findAll(new Company());
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
