package com.example.mapper_test.service;

import com.example.mapper_test.entity.User;
import java.util.List;

/**
* ClassName: UserService
* Description:
* date: Tue Jul 02 16:20:16 CST 2019
*/
public interface UserService {
    User selectById(String id);
    List<User> selectByPage(User user,int page,Integer limit);
    int selectCount(User user);

    int insertUser(User user);

    int updateUser(User user);
}
