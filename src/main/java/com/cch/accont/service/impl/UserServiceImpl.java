package com.cch.accont.service.impl;

import com.cch.accont.mapper.UserMapper;
import com.cch.accont.service.UserService;
import com.cch.base.service.impl.BaseServiceImpl;
import com.cch.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,String> implements UserService {

    @Resource
    private UserMapper userMapper;

    public User getByuserName(String username) {
        return userMapper.getByUserName(username);
    }

    public User getUser(String username, String passWd) {
        return userMapper.getUser(username,passWd);
    }

    public List<User> listAll() {
        return userMapper.findAll(new User());
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
