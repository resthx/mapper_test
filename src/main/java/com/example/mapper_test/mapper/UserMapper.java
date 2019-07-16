package com.example.mapper_test.mapper;

import com.example.mapper_test.entity.User;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* ClassName: UserMapper
* Description:
* date: Tue Jul 02 16:20:16 CST 2019
*/
public interface UserMapper extends BaseMapper<User> {
    List<User> selectByPage(User user,@Param("page") int page,@Param("limit") Integer limit);
    User selectById(@Param("id") String id);
    Integer selectCount(User user);
}