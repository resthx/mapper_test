package com.example.mapper_test.controller;

import com.example.mapper_test.entity.User;
/*import com.example.mapper_test.service.UserService;*/
import com.example.mapper_test.util.RespDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: UserController
 * Description:
 * date: 2019/6/22 14:45
 *
 * @author ji
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping("user")
public class UserController {
   /* @Autowired
    private *//**//*UserService userService;
    @RequestMapping("findAll")
    public RespDate findAll(User user){
        List<User> all = userService.findAll(user);
        return RespDate.set(0,all,null);
    }
    @RequestMapping("findById")
    public RespDate findById( String id){
        User user = userService.selectById(id);
        return RespDate.set(0,user,null);
    }
    @RequestMapping("find")
    public RespDate find(User user,@RequestParam("page") int page,@RequestParam(value = "limit",required = false) Integer limit){
        List<User> users = userService.selectByPage(user, page, limit);
        return RespDate.set(0,users,null);
    }*/
}
