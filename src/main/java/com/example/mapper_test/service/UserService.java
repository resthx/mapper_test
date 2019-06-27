package com.example.mapper_test.service;

import com.example.mapper_test.entity.User;
import java.util.List;

/**
* ClassName: UserService
* Description:
* date: Thu Jun 27 14:56:45 CST 2019
*/
public interface UserService {
    List<User> findUserAll(User user);
    User selectUserById(String id);
    List<User> selectUserByPage(User user,int page,Integer limit);
}
