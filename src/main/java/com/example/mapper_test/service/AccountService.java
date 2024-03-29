package com.example.mapper_test.service;

import com.example.mapper_test.entity.Account;
import java.util.List;

/**
* ClassName: AccountService
* Description:
* date: Tue Jul 02 15:48:52 CST 2019
*/
public interface AccountService {
    Account selectById(String id);
    List<Account> selectByPage(Account account,int page,Integer limit);
}
