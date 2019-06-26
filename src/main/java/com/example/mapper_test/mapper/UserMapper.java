package com.example.mapper_test.mapper;

import com.example.mapper_test.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: UserMapper
 * Description:
 * date: 2019/6/22 14:28
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
public interface UserMapper {
    List<User> selectUserByPage(User user,@Param("page") int page,@Param("limit") Integer limit);
    List<User> selectUser(User user);
    User selectById(@Param("id") String id);
    User selectByMobile(@Param("mobile") String mobile);
}