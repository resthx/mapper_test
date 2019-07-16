package com.example.mapper_test.mapper;

import com.example.mapper_test.entity.Account;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* ClassName: AccountMapper
* Description:
* date: Tue Jul 02 15:48:52 CST 2019
*/
public interface AccountMapper extends BaseMapper<Account> {
    List<Account> selectByPage(Account account,@Param("page") int page,@Param("limit") Integer limit);
    Account selectById(@Param("id") String id);
}