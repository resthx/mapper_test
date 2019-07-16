package com.example.mapper_test.service.impl;

import com.example.mapper_test.entity.Account;
import com.example.mapper_test.service.AccountService;
import com.example.mapper_test.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ClassName: AccountServiceImpl
* Description:
* date: Tue Jul 02 15:48:52 CST 2019
*/
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account selectById(String id) {
        return accountMapper.selectById(id);
    }

    @Override
    public List<Account> selectByPage(Account account, int page, Integer limit) {
        return accountMapper.selectByPage(account,page,limit);
    }
}
