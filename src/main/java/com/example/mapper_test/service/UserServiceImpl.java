package com.example.mapper_test.service;

import com.example.mapper_test.entity.User;
import com.example.mapper_test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Description:
 * date: 2019/6/22 14:46
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectByPage(User user, int page, Integer limit) {
        return userMapper.selectUserByPage(user,page,limit);
    }
}
