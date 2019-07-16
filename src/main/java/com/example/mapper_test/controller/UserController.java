package com.example.mapper_test.controller;

import com.example.mapper_test.entity.User;
import com.example.mapper_test.service.UserService;
import com.example.mapper_test.util.RespDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* ClassName: UserController
* Description:
* date: Tue Jul 02 16:20:16 CST 2019
*/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("user_list.html")
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView("admin/user/user_list");
        return modelAndView;
    }
    @RequestMapping("findById")
    public RespDate findById(@RequestParam("id") String id){
        User user = userService.selectById(id);
        return RespDate.set(0,user,null);
    }
    @RequestMapping("find")
    public RespDate find(User user,@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
        List<User> users = userService.selectByPage(user, page, limit);
        int count = userService.selectCount(user);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("users",users);
        resultMap.put("count",count);
        return RespDate.set(0,resultMap,null);
    }
}
