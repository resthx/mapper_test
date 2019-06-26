package com.example.mapper_test.service;

import com.example.mapper_test.entity.User;

import java.util.List;

/**
 * ClassName: UserService
 * Description:
 * date: 2019/6/22 14:45
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public interface UserService {
    List<User> findAll(User user);
    User selectById(String id);
    List<User> selectByPage(User user,int page,Integer limit);
}
