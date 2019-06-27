package com.example.mapper_test.service.impl;

import com.example.mapper_test.entity.User;
import com.example.mapper_test.service.UserService;
import com.example.mapper_test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ClassName: UserServiceImpl
* Description:
* date: Thu Jun 27 14:56:45 CST 2019
*/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUserAll(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectUserByPage(User user, int page, Integer limit) {
        return userMapper.selectUserByPage(user,page,limit);
    }
}
