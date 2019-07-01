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
* date: Mon Jul 01 15:09:16 CST 2019
*/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectByPage(User user, int page, Integer limit) {
        return userMapper.selectByPage(user,page,limit);
    }
}
