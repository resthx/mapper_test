package com.example.mapper_test.controller;

import com.example.mapper_test.entity.Account;
import com.example.mapper_test.service.AccountService;
import com.example.mapper_test.util.RespDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* ClassName: AccountController
* Description:
* date: Tue Jul 02 15:48:52 CST 2019
*/
@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("findById")
    public RespDate findById(@RequestParam("id") String id){
        Account account = accountService.selectById(id);
        return RespDate.set(0,account,null);
    }
    @RequestMapping("find")
    public RespDate find(Account account,@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
        List<Account> accounts = accountService.selectByPage(account, page, limit);
        return RespDate.set(0,accounts,null);
    }
}
